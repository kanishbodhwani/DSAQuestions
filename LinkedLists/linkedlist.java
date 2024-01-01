public class LinkedList {

    private Node head;
    private Node tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void inserLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;

        if(head == null) {
            tail = null;
        }

        size--;
        return val;
    }

    public int deleteLast() {
        if(size <= 1) {
            deleteFirst();
            return;
        }
        Node temp = get(size - 2);
        int val = temp.value;
        tail = temp;
        temp.next = null;

        return val;
    } 


    public int delete(int index) {
        if(index == 0) {
            return deleteFirst();
        }
        if(index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index - 1);
        prev.next = prev.next.next;
        return prev.next.val;
    }

    public Node find(int value) {
        Node node = head;
        while(node != null) {
            if(node.value == value) {
                return node;
            }
            node = node.next 
        }
        return node;
    }

    public Node get(int index) {
        Node node = head;
        for(int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void insert(int val, in index) {
        if(index == 0) {
            inserFirst(val);
            return;
        }

        if(index == size) {
            inserLast(val);
            return;
        }

        Node temp = head;

        for(int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val, temp.next);
        temp.next = newNode;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}