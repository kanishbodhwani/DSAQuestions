import { Component, OnInit, AfterViewInit, ViewChild, ElementRef } from '@angular/core';
import { AuthTokenService } from './security';
import { NgbDate, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DateRangeUtil, DateRange, DateDetails, DateUtil } from './utils';
import { ShiftPlannerService, UsersService } from './services';
import { Employee, ShiftItem, Vessel, VesselSchedule, LoggedInUser, ShiftDayItem } from './model';
import { LoaderService } from './services/loader.service';
import { forkJoin, fromEvent } from 'rxjs';
import { map, debounceTime} from 'rxjs/operators';
import { ShiftsViewComponent, ShiftViewItem } from './shifts-view/shifts-view.component';
import { ToastContainerDirective, ToastrService } from 'ngx-toastr';
import { getDay } from 'date-fns';
import { daysToWeeks } from 'date-fns/esm';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, AfterViewInit {
  weekStart = '';
  weekEnd = '';

  //For filters
  allVessel: Vessel = {
    id: undefined,
    name: 'All Vessels',
    schedules: undefined,
    staffShifts: undefined
  };
  allPosition = 'All Positions';
  selectedPosition: string = this.allPosition;
  selectedVessel: Vessel = this.allVessel;
  private employeeName: string;
  pristineData: Vessel[];
  employeePositions = [];


  private employees: Map<string, Employee>;

  private selectedDate: Date | null = null;
  private dateRange: DateRange | null = null;
  hoveredDate: NgbDate | null = null;
  loading = false;

  vessels: Vessel[] = [];
  weekDays: Map<number, string> = new Map();

  loggedInUser: LoggedInUser;

  @ViewChild('employeeName') employeeNameElement: ElementRef;

  get isFilterApplied(): boolean {
      return (this.employeeName && this.employeeName.length > 0) || (this.selectedPosition != this.allPosition)|| (this.selectedVessel != this.allVessel);
  }

  @ViewChild(ToastContainerDirective, { static: true })
  toastContainer: ToastContainerDirective;

  constructor(private loaderService: LoaderService,
    private tokenService: AuthTokenService,
    private modalService: NgbModal,
    private userService: UsersService,
    private toastrService: ToastrService,
    private shiftPlannerService: ShiftPlannerService) {
    this.loaderService.showBusyCursor().subscribe((v) => {
      setTimeout(() => {
        this.loading = v;
      });
    });
  }

  ngOnInit(): void {
    this.toastrService.overlayContainer = this.toastContainer;
    this.tokenService.onTokenChange().subscribe((token: string) => {
      if (token) {
        this.userService.getLoggedInUser().subscribe((loggedInUser) => {
          this.loggedInUser = loggedInUser;
          forkJoin({
            employees: this.shiftPlannerService.getEmployees(),
            vessels: this.shiftPlannerService.getVessels()
          }).subscribe(({ employees, vessels }) => {
            console.log('Got all vessels!');
            vessels.forEach((vessel: Vessel) => {
              this.weekDays.forEach((weekDayName, weekDayId) => {
                vessel.schedules.set(weekDayId, undefined);
              });
            });
            this.vessels = vessels;
            this.employees = employees;
            this.populateEmployeePositions(Array.from(employees.values()));
            this.getShiftsForSelectedWeek();
          });
        });
      }
    });
    this.dateRange = DateRangeUtil.getWeekForDate();
    this.populateDateDetails(this.selectedDate, this.dateRange);
  }

  ngAfterViewInit(): void {
    fromEvent(this.employeeNameElement.nativeElement, 'keyup')
      .pipe(map((evt: any) => evt.target.value),
        debounceTime(850)
      )
      .subscribe(name => {
        if (name === '' || name === null || name === undefined) {
          this.employeeName = '';
        } else {
          this.employeeName = name.toLowerCase();
        }

        this.applyFilter();
      });
  }

  private getAllShiftsForDate(dateInMS: number): Map<Vessel, ShiftViewItem[]> {
    const vesselShifts: Map<Vessel, ShiftViewItem[]> = new Map();
    this.vessels.forEach((vessel: Vessel) => {
      const shifts: ShiftViewItem[] = [];
      vessel.staffShifts.forEach((staffShifts, staff) => {
        console.log(staffShifts);
        if (staffShifts.has(dateInMS)) {
          const staffShift = staffShifts.get(dateInMS);
          shifts.push({
            name: staff.name,
            position: staffShift.position,
            start: new Date(staffShift.start),
            end: new Date(staffShift.end)
          })
        }
      });
      vesselShifts.set(vessel, shifts);
    });
    console.log(vesselShifts);
    return vesselShifts;
  }

  private getAllShiftsForSameDayAndName(): Map<Employee, ShiftDayItem[]> {

    // key - day
    // value - [name, shift]

    // {
    //   key: 0,
    //   value: [
    //     0: {
    //       name: "Anup Mohan",
    //       shift: "2:10"`
    //     },
    //     1: {
    //       name: "Trgvye",
    //       shift: "4:10"
    //     }
    //   ]
    // }

    // add totalshiftlength to shift item
    // for that day for that employee


    const vesselShifts: Map<Employee, shifts> = new Map();
    this.vessels.forEach((vessel: Vessel) =>  {
      if(vessel.staffShifts?.size !== 0) {
        const shifts: Map<String, ShiftLength> = new Map();
        vessel.staffShifts.forEach((staffShifts, staff) => {
          staffShifts.forEach((staffShift) => {
            let date = staffShift.date;
            let day = getDay(date);
            if(vesselShifts.has) {
              let key = day;
              // if(staffShift.name === ) {
                // name is same I'll add the shift lenght
                // then make a object in that arr of values
              // }
              shifts.push({
                name: staffShift.name,
                shiftLength: staffShift.shiftLength
              })
              // vesselShifts.set(key, shifts)
            } else {
              // add that day which is 0 , 1, 2 etc
              // shifts.push({
              //   name: staffShift.name,
              //   shift: staffShift.shift
              // })
              // vesselShifts.set(day, shifts);
            }
          })
        })
      }
    })
    return vesselShifts;
  }

  onDayShiftsView(dateInMS: number): void {
    const vesselShifts = this.getAllShiftsForDate(dateInMS);
    const modalRef = this.modalService.open(ShiftsViewComponent, {size: 'lg', scrollable: true});
    (modalRef.componentInstance as ShiftsViewComponent).options = {
      dayView: true,
      viewDate: new Date(dateInMS),
      vesselShifts: vesselShifts
    };
  }

  private populateEmployeePositions(employees: Employee[]): void {
    const positionsSet: Set<string> = new Set();
    employees.forEach((employee) => {
      positionsSet.add(employee.position);
    });
    this.employeePositions = Array.from(positionsSet.values());
    this.employeePositions.unshift(this.allPosition);
  }

  private getShiftsForSelectedWeek(): void {
    const start = this.dateRange.start;
    const end = this.dateRange.end;

    forkJoin({
      schedules: this.shiftPlannerService.getVesselSchedules(start, end),
      shifts: this.shiftPlannerService.getShifts(start, end, this.loggedInUser)
    }).subscribe(({ schedules, shifts }) => {
      this.clearVesselData();
      const vesselByVesselSchedule: Map<number, number> = new Map();
      schedules.forEach(vesselSchedule => vesselSchedule.forEach(vs => vesselByVesselSchedule.set(vs.id, vs.vesselId)));
      if (!shifts) {
        shifts = [];
      }
      const shiftsByVesselAndStaff = this.groupShiftsByVesselAndStaff(shifts, vesselByVesselSchedule);

      this.vessels.forEach((vessel: Vessel) => {
        const vesselSchedules = schedules.get(vessel.id) || [];
        vesselSchedules.forEach((vesselSchedule: VesselSchedule) => {
          const dateInMilli = DateUtil.getUTC_DateFromString(vesselSchedule.start).getTime();
          vessel.schedules.set(dateInMilli, vesselSchedule);
        });

        const staffShifts = shiftsByVesselAndStaff.get(vessel.id);
        if (staffShifts) {
          vessel.staffShifts = staffShifts;
        }
        // this.getAllShiftsForSameDayAndName();
      });

      this.pristineData = this.cloneVesselData(this.vessels);

      if (this.isFilterApplied) {
        this.applyFilter();
      }
    });
  }

  private clearVesselData(): void {
      this.vessels.forEach((vessel) => {
        vessel.schedules = new Map();
        vessel.staffShifts = new Map();
      });
  }

  private cloneVesselData(vessels: Vessel[]): Vessel[] {
    return vessels.map((vessel) => {
      const staffShifts: Map<Employee, Map<number, ShiftItem>> = new Map();
      vessel.staffShifts.forEach((shifts: Map<number, ShiftItem>, employee: Employee) => {
        staffShifts.set(employee, new Map(shifts));
      });
      return {
        id: vessel.id,
        name: vessel.name,
        schedules: new Map(vessel.schedules),
        staffShifts: new Map(staffShifts)
      }
    });
  }

  private groupShiftsByVesselAndStaff(shifts: ShiftItem[], vesselByVesselSchedule: Map<number, number>): Map<number, Map<Employee, Map<number, ShiftItem>>> {
    const shiftsByVesselAndStaff: Map<number, Map<Employee, Map<number, ShiftItem>>> = new Map();
    shifts.forEach((shift) => {
      const vesselId = vesselByVesselSchedule.get(shift.vesselSchedule.id);
      if (vesselId) {
        const employee = this.employees.get(shift.name);
        if (employee) {
          const staffShiftsMap: Map<Employee, Map<number, ShiftItem>> = shiftsByVesselAndStaff.get(vesselId) || new Map();
          let weekdDaysStaffShifts: Map<number, ShiftItem> = staffShiftsMap.get(employee) || new Map();
          weekdDaysStaffShifts.set(shift.date, shift);
          staffShiftsMap.set(employee, weekdDaysStaffShifts);
          shiftsByVesselAndStaff.set(vesselId, staffShiftsMap);
        }
      }
    });
    return shiftsByVesselAndStaff;
  }

  private populateDateDetails(selectedDate: Date = new Date(), dateRange: DateRange): void {
    const weekDetails = DateRangeUtil.getWeekForDateAsDetails(selectedDate);
    const weekStartDetails = weekDetails[0];
    const weekEndDetails = weekDetails[weekDetails.length - 1];

    this.weekStart = weekStartDetails.month + ' ' + weekStartDetails.date;
    this.weekEnd = weekEndDetails.month + ' ' + weekEndDetails.date;

    this.populateColumns(weekDetails);
  }

  private populateColumns(weekDetails: DateDetails[]): void {
    this.weekDays.clear();
    weekDetails.forEach((weekDetail) => {
      this.weekDays.set(weekDetail.inMilli, weekDetail.dayShort + ' ' + weekDetail.date);
    });
  }

  applyFilter(): void {
    let filteredData: Vessel[] = this.cloneVesselData(this.pristineData);
    const applyPositionFilter = (this.selectedPosition && this.selectedPosition !== this.allPosition);
    const applyNameFilter = (this.employeeName && this.employeeName.length > 0);
    if (this.selectedVessel && this.selectedVessel.id) {
      filteredData = filteredData.filter(vessel => vessel.id === this.selectedVessel.id)
    }
    if (applyPositionFilter || applyNameFilter) {
      filteredData.forEach((filteredVessel) => {
        const matchingShifts: Map<Employee, Map<number, ShiftItem>> = new Map();
        filteredVessel.staffShifts.forEach((shifts: Map<number, ShiftItem>, employee: Employee) => {
          let isMatching = false;
          if (applyPositionFilter) {
            isMatching = employee.position === this.selectedPosition;
            if (isMatching && applyNameFilter) {
              isMatching = employee.name.toLowerCase().indexOf(this.employeeName) >= 0;
            }
          } else if (applyNameFilter) {
            isMatching = employee.name.toLowerCase().indexOf(this.employeeName) >= 0;
          }

          if (isMatching) {
            matchingShifts.set(employee, shifts);
          }
        });
        filteredVessel.staffShifts = matchingShifts;
      });
    }
    this.vessels = filteredData;
  }

  onDateSelect(date) {
    this.selectedDate = new Date(date.year, date.month - 1, date.day)
    this.dateRange = DateRangeUtil.getWeekForDate(this.selectedDate);
    this.populateDateDetails(this.selectedDate, this.dateRange);
    this.getShiftsForSelectedWeek();
  }

  isRange(ngbDate: NgbDate) {
    let date = new Date(ngbDate.year, ngbDate.month - 1, ngbDate.day)
    return this.dateRange ? DateRangeUtil.isWithinWeek(this.dateRange, date) : false;
  }

  previousWeek() {
    let previousWeekDay = this.dateRange.start;
    previousWeekDay.setDate(previousWeekDay.getDate() - 2);
    this.dateRange = DateRangeUtil.getWeekForDate(previousWeekDay);
    this.populateDateDetails(previousWeekDay, this.dateRange);
    this.getShiftsForSelectedWeek();
  }

  nextWeek() {
    let nextWeekDay = this.dateRange.end;
    nextWeekDay.setDate(nextWeekDay.getDate() + 1);
    this.dateRange = DateRangeUtil.getWeekForDate(nextWeekDay);
    this.populateDateDetails(nextWeekDay, this.dateRange);
    this.getShiftsForSelectedWeek();
  }

  isHovered(ngbDate: NgbDate): boolean {
    let date = new Date(ngbDate.year, ngbDate.month - 1, ngbDate.day);
    if (this.hoveredDate != null) {
      let hoveredDate = new Date(this.hoveredDate.year, this.hoveredDate.month - 1, this.hoveredDate.day);
      const dateRange = DateRangeUtil.getWeekForDate(hoveredDate);
      return dateRange ? DateRangeUtil.isWithinWeek(dateRange, date) : false;
    }
    return false;
  }

  getShiftClass(shiftType: string): string {
    switch (shiftType) {
      case 'Night':
        return 'nightShift';
      case 'Day':
        return 'dayShift';
      default:
        return 'otherShift';
    }
  }
}
