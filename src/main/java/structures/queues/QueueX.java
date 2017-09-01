package structures.queues;

public class QueueX<T> {

    int maxSize;
    Object[] queArray;
    int front;
    int rear;
    int nItems;

    public QueueX(){
        this(10);
    }

    public QueueX(int maxSize){
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
        this.queArray = new Object[maxSize];
    }

    public void insert(T el){
        if(nItems == maxSize){grow(nItems+1);}
        else if(rear+1 == maxSize){rear = -1;}
        nItems++;
        queArray[++rear] = el;
    }

    public T remove(){
        if(isEmpty()) return null;
        else if(front == maxSize-1){ front = 0;}
        T temp = (T) queArray[front++];
        nItems--;
        return temp;
    }

    public T peek(){
        if(isEmpty()) return null;
        return (T) queArray[front];
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    private void grow(int minCapacity) {
        int oldCapacity = queArray.length;
        int newCapacity = oldCapacity * 2;
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        Object[] newArray = new Object[newCapacity];
        int j;
        for(j = 0; j < nItems; j++){
            if(front == maxSize) front = 0;
            newArray[j] = queArray[front++];
            System.out.println("newArray["+j+"] = "+newArray[j]+";");
        }
        rear = j-1;
        front = 0;
        maxSize = newCapacity;
        queArray = newArray.clone();
    }

}