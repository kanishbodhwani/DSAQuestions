public void removeDuplicates() {
    Node node = head;

    while(node.next != null) {
        if(node.val == node.next.val) {
            node.next = node.next.next;
            s--;
        } else {
            node = node.next;
        }
    }
    tail = node;
    tail.next = null;
}