package algosamples.datastructures;

public class MyStack<X> {

    private X[] data;
    private int size;
    private int capacity;

    public MyStack(int cap) {
        this.capacity = cap;
        this.size = 0;
        this.data = (X[]) new Object[capacity];
    }

    public void push(X item) {
        if (size >= capacity) {
            throw new IllegalStateException("Stack overflow");
        }

        data[size++] = item;
        System.out.println("Pushed " + item + " onto stack");
    }

    public X pop() {
        if (size <= 0) {
            throw new IllegalStateException("Stack underflow");
        }

        X item = data[--size];
        System.out.println("Popped " + item + " from stack");
        return item;
    }

    public boolean contains(X item) {
        Boolean found = false;

        for(int i = size - 1; i >= 0; i--) {
            if (data[i] == item) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void main(String a[]) {
        MyStack<Integer> myStack = new MyStack<Integer>(5);
        myStack.push(1);
        myStack.push(2);
        myStack.pop();
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println(myStack.contains(2));
        System.out.println(myStack.contains(1));
        System.out.println(myStack.contains(7));
    }
}
