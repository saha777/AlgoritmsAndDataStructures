package structures.lists;

import java.util.*;
import java.util.function.Consumer;

public class ArrayList<T> implements List<T>{

    int maxSize;
    Object[] array;
    int front;
    int rear;
    int nItems;

    public ArrayList(){
        this(10);
    }

    public ArrayList(int maxSize){
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
        this.array = new Object[maxSize];
    }

    public void insertFirst(T t) {
        if(nItems >= maxSize) grow(maxSize+1);
        for(int i = nItems-1; i >= 0; i--){
            array[i+1] = array[i];
        }
        array[0] = t;
        nItems++;
    }


    public void insertLast(T t) {
        if(nItems >= maxSize) grow(maxSize+1);
        array[nItems++] = t;
    }

    @Override
    public void insert(int index, T t) {
        if(index < 0){return;}
        if(nItems >= maxSize) grow(maxSize+1);
        for(int i = nItems-1; i >= index; i--){
            array[i+1] = array[i];
        }
        array[index] = t;
        nItems++;
    }

    public T deleteFirst() {
        emptyCheck();
        T temp = (T) array[0];
        for(int i = 1; i < nItems; i++){
            array[i-1] = array[i];
        }
        nItems--;
        return temp;
    }

    public T deleteLast() {
        emptyCheck();
        return(T) array[--nItems];
    }

    @Override
    public T delete(int index) {
        rangeCheck(index);

        T temp = (T) array[index];

        nItems--;

        for (int i = index; i < nItems; i++) {
            array[i] = array[i + 1];
        }

        return temp;
    }

    public T getFirst() {
        emptyCheck();
        return (T) array[0];
    }

    public T getLast() {
        emptyCheck();
        return (T) array[nItems-1];
    }

    public void setFirst(T t){
        emptyCheck();
        array[0] = t;
    }

    public void setLast(T t){
        emptyCheck();
        array[nItems - 1] = t;
    }

    public void set(int index, T t){
        rangeCheck(index);

        array[index] = t;
    }

    public T get(int index){
        rangeCheck(index);

        return (T) array[index];
    }

    public int size() {
        return nItems;
    }

    public boolean contains(Object ob) {
        int flag = 0;
        for (int i = 0; i < size(); i++){
            T temp = (T) array[i];
            if(temp.equals((T) ob)){
                flag = 1;
                break;
            }
        }
        if (flag == 1) return true;
        return false;
    }

    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void show() {
        System.out.print("ArrayList: ");
        for(int i = 0; i < size(); i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void rangeCheck(int index) {
        if (index >= nItems || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+nItems;
    }

    @Override
    public void emptyCheck(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("ArrayList is empty");
    }

    @Override
    public long getNanoTime() {
        return System.nanoTime();
    }

    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity * 2;

        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;

        Object[] newArray = new Object[newCapacity];

        int j;
        for(j = 0; j < nItems; j++){
            if(front == maxSize) front = 0;
            newArray[j] = array[front++];
        }

        rear = j-1;
        front = 0;
        maxSize = newCapacity;
        array = newArray.clone();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            int currentIndex = front;

            @Override
            public boolean hasNext() {
                return currentIndex < nItems && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }

            @Override
            public void remove(){
                if(isEmpty()|| currentIndex > nItems-1 || currentIndex < 0){return;}

                nItems--;

                for (int i = currentIndex; i < nItems; i++) {
                    array[i] = array[i + 1];
                }
            }
        };
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        @SuppressWarnings("unchecked")
        final T[] elementData = (T[]) this.array;
        final int size = this.nItems;
        for (int i=0; i < size; i++) {
            action.accept(elementData[i]);
        }
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) array, 0, nItems, c);
    }
}
