public class ReverseLinkedList {
    private void reverse(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    } 

    // in place reversal of linked list
    
    public void reverse() {
        if(size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    // Reverse a linked list II (a part of list)

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }

        // skip the first left - 1 notes
        ListNode current = head;
        ListNode prev= null;

        for(int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // reverse between left and right 
        ListNode next = current.next;
        for(int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) {
                next = next.next;
            }
        }

        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }

}