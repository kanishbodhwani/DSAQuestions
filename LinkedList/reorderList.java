class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        
        ListNode mid = middleNode(head);
        
        ListNode hs = reverseList(mid);
        ListNode hf = head;
        
        //rearrange 
        while(hf != null && hs != null) {
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
            
        // next of tail to null
        if(hf != null) {
            hf.next = null;
        }
    }
    
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    public void reverse() {
//        if(size < 2) {
//            return;
//        }
        
        Node prev = null;
        Node pres = head;
        Node next = pres.next;
        
        
        while(pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null) {
                next = next.next;
            }
        }
        head = prev;
    } 
}