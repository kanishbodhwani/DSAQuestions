// find lenght of the cycle
// Apply fast and slow pointer method 


public class Solution {
    public boolean lenghtCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                // calculate the length
                
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while(temp != slow)
                
                return length;
            }
        }
        
        return false;
    }
}