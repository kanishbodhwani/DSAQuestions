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

    // reverse a linked list using recursion 
    private void reverse(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }
        
        reverse(node.next);
        
        tail.next = node;
        tail= node;
        tail.next = null;
    }
        
    
    // reverse a linked list using iteration
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