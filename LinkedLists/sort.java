// Sort a linked list
public class Sort {

    public ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);

        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
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

    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }


    // Bubble sort
    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if(row == 0) {
            return;
        }

        if(col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if(first.value > second.value) {
                // 3 cases 
                if(first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if(second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    second.next = first;
                    first.next = null;
                    tail = first;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }

            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }
}