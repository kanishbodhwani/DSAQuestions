public class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public int add(int item) {
        first.push(item);
    }

    public int remove() {
        while(first.isEmpty()) {
            second.push(first.pop());
        }
        int popped = second.pop();
        while(second.isEmpty()) {
            first.push(second.pop());
        }
        return popped;
    }

    public int peek() {
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }
}

// Remove Efficient

public class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public int add(int item) {
        while(!first.isEmpty()) {
            second.push(first.pop());
        }
        first.push(item);
        while(!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() {
        return first.pop();
    }

    public int peek() {
        return fisrt.peek();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }
}