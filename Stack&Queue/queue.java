public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if(this.isFull()) {
            int[] temp = new int[data.length * 2];

            for(int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}

public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    } 

    public boolean isFull() {
        return size = data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if(isFull()) {
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() {
        if(isEmpty()) {
            return false;
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        } while(i != end);
        System.out.println("END");
    }
}

public class CustomQueue {
    private int[] data;

    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end = data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if(isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[0];

        for(int i = 0; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void display() {
        for(int i = 0; i < end; i++) {
            System.out.println(data[i] + " ");
        }
        System.out.println();
    }
}


import java.util.Queue;

public class Queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 1
        queue.add(2); // 1 2
        queue.add(3); // 1 2 3
        queue.remove(); // 2 3
        queue.remove(); // 3
        queue.add(4); // 3 4
        queue.peek(); // 3

        Deque<Integer> deque = new ArrayDeque<>();
        // insertion and deletion at both ends
        // ArrayDeque is faster than LinkedList
        // ArrayDeque is resizable
    }
}