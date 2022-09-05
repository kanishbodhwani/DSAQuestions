
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reReverseHead = headSecond;
    }
    
    // compare both the halves
    while(head != null && headSecond != null) {
        if(head.val != headSecond.val) {
            break;
        }
        head = head.next;
        headSecond = headSecond.next;
    }
    reverseList(reverseHead);
    return head == null || headSecond == null;
}


