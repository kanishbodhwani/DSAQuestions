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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }    
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        
        return merge(left, right);
    }
    
    
//    public ListNode merge(ListNode f, ListNode s) {
//        ListNode dummyHead = new ListNode();
//        ListNode tail = dummyHead;
//        
//        while(f != null && s != null) {
//            if(f.val < s.val) {
//                tail.next = f;
//                f = f.next;
//                tail = tail.next;
//            } else {
//                tail.next = s;
//                s = s.next;
//                tail = tail.next;
//            }
//        }
//        
//        tail.next = (f != null) ? f : s;
//        return dummyHead.next;
//    }
    
    
    
   
//    
//    public ListNode getMid(ListNode head) {
//        ListNode midPrev = null;
//        while(head != null && head.next != null){
//            midPrev = (midPrev == null) ? head :                              midPrev.next;
//            head = head.next.next;    
//        } 
//        ListNode mid = midPrev.next;
//        midPrev.next = null;
//        return mid;
//    }
    
    
     
    // bubble sort 
    
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
                //swap
                if(first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.ext = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubblesort(row - 1, 0);
        } 
    }
}