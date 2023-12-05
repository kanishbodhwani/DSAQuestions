// Linked Lists 

// Non continious memory allocation 
// Boxes connected with each other (Nodes) [] -> [] -> [] -> []

// Singly Linked Lists
// Each node contains value and next 
// next is just refrence to another node (Itself is a node)

// We have only head, with which we have to do all the questions

public class LinkedLists {
    
    private Node head;
    private Node tail;
    
    private int size;
    
    public LL() {
        this.size = 0;
    }
    
    public void insertFirst(int val) {
        Node node = new Node;
        node.next = head;
        head = node;
        
        if(tail == null){
            tail = head;        
        }    
        size += 1;
    }   
    
    public void display() {
        Node temp = head;
        
        while(temp != null) {
            // print
            temp = temp.next;
        }
    }
    
    
    public void insertAtIndex(int index, int val) {
        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }
    
    private class Node {
        private int val;
        private Node next;
        
        public Node(int val){
            this.val = val;
        }
        
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}