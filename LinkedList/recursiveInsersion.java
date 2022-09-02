// 2 -> 5 -> 7 -> 43
public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }


    public void insertFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;

        if(tail == null) {
            tail = head;
        }
        size++;
    }


    public void insertLast(int val) {
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;

        if(head == null) {
            head = tail;
        }
        size++;
    }


    public void insertAtIndex(int index,int val) {
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    
    // insert using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }
    
    private Node insertRec(int val, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(int val);
            size++;
            return temp;
        }
        
        node.next = insertRec(val, index--, node.next);
        return node;
    }
    
    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public Node get(int index) {
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

}