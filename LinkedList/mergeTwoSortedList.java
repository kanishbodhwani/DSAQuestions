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

// Question 
// Remove duplicates

    public static LL merge(LL first, LL second) {
        Node f = fisrt.head;
        Node s = second.head;
        
        LL ans = new LL();
        
        while(f != null && s != null) {
            if(f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        
        while(f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }
        
        while(s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
        
    }
    
}




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
    public ListNode mergeTwoLists(ListNode f, ListNode s) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        
        while(f != null && s != null) {
            if(f.val < s.val) {
                tail.next = f;
                f = f.next;
                tail = tail.next;
            } else {
                tail.next = s;
                s = s.next;
                tail = tail.next;
            }
        }
        
        tail.next = (f != null) ? f : s;
        return dummyHead.next;
    }
}
















