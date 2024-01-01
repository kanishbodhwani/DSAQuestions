// merge two Linked Lists
public static LL merge(LL first, LL second) {
    Node f = first.head;
    Node s = second.head;

    LL ans = new LL();

    while(f != null && s != null) {
        if(f.value < s.value) {
            ans.insertLast(f.value);
            f = f.next;
        } else {
            ans.insertLast(s.value);
            s = s.next;
        }
    }

    while(f != null) {
        ans.insertLast(f.value);
        f = f.next;
    }

    while(s != null) {
        ans.insertLast(s.value);
        s = s.next;
    }

    return ans;
}

public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode();
    ListNode tail = dummyHead;

    while(list1 != null && list2 != null) {
        if(list1.val < list2.val) {
            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;
        } else {
            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }
    }

    tail.next = (list1 != null) ? list1 : list2;
    return dummyHead.next;
}

