// Middle of linked list 
// same as fast and slow pointer

public ListNode middleNode(ListNode head) {
    ListNode f = head;
    ListNode s = head;

    while(f != null && f.next != null) {
        f = f.next.next;
        s = s.next;
    }

    return s;
}
