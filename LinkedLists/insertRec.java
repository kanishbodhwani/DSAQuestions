// O(n) - time complexity 
// o(n) - space complexity 

public void insertRec(int val, int index) {
    head = inserRec(val, index, head);
}

private Node inserRec(int val, int index, Node node) {
    if(index == 0) {
        Node temp = new Node(val, node);
        size++;
        return temp;
    }

    node.next = insertRec(val, index--, node.next);
    return node;
}