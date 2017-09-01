package structures.queues;

public class PriorityQueueX<T> implements CollectionX<T> {

    private int maxSize;
    private Object[] queArray;
    private int nItems;

    public PriorityQueueX(){
        this(10);
    }

    public PriorityQueueX(int maxSize) {
        this.maxSize = maxSize;
        nItems = 0;
        queArray = new Object[maxSize];
    }

    public void insert(T el) {
        int j;
        if(nItems == 0){
            queArray[nItems++] = el;
        }
        else{
            for(j = nItems-1; j >= 0; j--){
                if(el.hashCode() < queArray[j].hashCode()){
                    queArray[j+1] = queArray[j];
                }
                else break;
            }
            queArray[j+1] = el;
            nItems++;
        }

    }

    public T remove(){
        return (T) queArray[--nItems];
    }

    public T peek() {
        return (T) queArray[nItems-1];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

}