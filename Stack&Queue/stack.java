import java.util.Stack;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if(isFull()) {
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Cannot pop from empty stack");
        }
        return data[ptr--];
    }

    public int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Cannot peek from empty stack");
        }
        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }
    
    public boolean isEmpty() {
        return ptr == -1;
    }
}

public class DynamicStack extends CustomStack {
    public DynamicStack() {
        super(); // it will call CustomStack() constructor
    }

    public DynamicStack(int size) {
        super(size); // it will call CustomStack(int size) constructor
    }

    @Override
    public boolean push(int item) {
        if(this.isFull()) {
            int[] temp = new int[data.length * 2];

            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        return super.push(item);
    }
}


public class Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1); // 1
        stack.push(2); // 1 2
        stack.push(3); // 1 2 3
        stack.pop(); // 1 2
        stack.pop(); // 1
        stack.push(4); // 1 4
    }
}