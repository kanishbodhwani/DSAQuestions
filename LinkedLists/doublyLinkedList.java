public class DoublyLinkedList {

    Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head.prev != null) {
            head.prev = node;
        }
        head = node;
    }

    public void display() {
        Node node = head;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    public void displayReverse() {
        Node node = head;
        Node last = null; 
        while(node != null) {
            last = node;
            node = node.next;
        }

        if(last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    public void insert(int after, int val) {
        Node p = find(after);
        if(p == null) {
            // Does not exists 
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null) {
            node.next.prev = node;
        }
    }

    public Node find(int value) {
        Node node = head;
        if(node != null) {
            if(node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insertLast(int val) {
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }

        Node newNode = new Node(val, last, null);
        last.next = newNode;
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

}