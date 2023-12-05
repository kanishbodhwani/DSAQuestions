/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// [1] - [2] - [3] - [4] - [5]

// left = 2 , right = 4

// [5] <- [2] <- [3] <- [4] <- [1]

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        ListNode current = head;
        ListNode prev = null;
        for(int i = 0;  current != null && i < left - 1; i++) {
            prev = current;
            current = current.next; 
        }
        
        ListNode last = prev;
        ListNode newEnd = current;
        
        // reverse between left and right
        ListNode next = current.next;
        // current = 2, prev = 1, last = 1, newEnd = 2, next = 3
        
        for(int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev; 
            prev = current; // prev = 2,3,4
            current = next; // current = 3,4,5
            if(next != null) {
                next = next.next; // next = 4,5,null
            }
        }
        
        if(last != null) {
            last.next = prev;
        } else {
            // last == null
            head = prev;
        }
        
        newEnd.next = current;
        return head;
    }
}