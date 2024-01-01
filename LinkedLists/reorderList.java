public void reorderList(ListNode head) {
    if(head == null || head.next = null) {
        return;
    }

    ListNode mid = middleNode(head);

    ListNode hf = head;
    ListNode hs = reverse(mid);

    // rearrange
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