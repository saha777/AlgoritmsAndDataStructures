package structures.stack;

import java.util.Arrays;

public class StackX<T> {

    int maxSize;
    Object[] stackArray;
    int top;

    public StackX() {
        this(10);
    }

    public StackX(T[] stackArray){
        maxSize = stackArray.length;
        this.stackArray = stackArray;
        top = -1;
    }

    public StackX(int maxSize){
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1;
    }

    public void insert(T elem){
        ensureCapacityHelper(top + 1);
        stackArray[++top] = elem;
    }

    public T pop(){
        //if(top < 0) return null;
        return (T) stackArray[top--];
    }

    public T peek(){
        //if(top < 0) return null;
        return (T) stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

    private void ensureCapacityHelper(int minCapacity) {
        if (minCapacity - stackArray.length >= 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int oldCapacity = stackArray.length;
        int newCapacity = oldCapacity * 2;
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        stackArray = Arrays.copyOf(stackArray, newCapacity);
    }

}