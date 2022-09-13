public ListNode reverseKGroup(ListNode head, int k) {
    if(k <= 1 || head == null){
        return head;
    }
    
    if(left == right) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
    
        while(true) {
            ListNode last = prev;
            ListNode newEnd = current;

            // reverse between left and right
            ListNode next = current.next;
            for(int i = 0; current != null && i < k; i++) {
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
                // last == null
                head = prev;
            }
        
            newEnd.next = current;
            if(current == null) {
                break;
            } 
            prev = newEnd; 
        }
        
    return head;
    
        
}
