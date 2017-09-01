package structures.lists;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class LinkedList<T> implements List<T>{

    int size;
    Link first;
    Link last;

    public LinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void insertFirst(T t){
        Link newLink = new Link(t);

        if(isEmpty()){
            last = newLink;
        }else{
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;

        size++;
    }

    @Override
    public void insertLast(T t){
        Link newLink = new Link(t);

        if(isEmpty()){
            first = newLink;
        }else{
            last.next = newLink;
        }

        newLink.previous = last;
        last = newLink;

        size++;
    }

    @Override
    public void insert(int index, T t){
        rangeCheck(index);

        Link current = getLink(index);

        Link newLink = new Link(t);

        if(current == first){
            first = newLink;
        }else{
            current.previous.next = newLink;
        }
        newLink.previous = current.previous;
        newLink.next = current;
        current.previous = newLink;

        size++;
    }

    @Override
    public T deleteFirst() {
        Link temp = first;

        emptyCheck();

        first = first.next;
        first.previous = null;

        size--;

        return (T) temp.data;
    }

    @Override
    public T deleteLast() {
        Link temp = last;

        emptyCheck();

        last = last.previous;
        last.next = null;

        size--;

        return (T) temp.data;
    }

    @Override
    public T delete(int index){
        rangeCheck(index);

        Link current = getLink(index);

        if(current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if(current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;

        size--;

        return (T) current.data;
    }

    @Override
    public T getFirst() {
        emptyCheck();
        return (T) first.data;
    }

    @Override
    public T getLast() {
        return (T) last.data;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        Link current = getLink(index);
        return (T) current.data;
    }

    @Override
    public void setFirst(T t) {
        emptyCheck();
        first.data = t;
    }

    @Override
    public void setLast(T t) {
        emptyCheck();
        last.data = t;
    }

    @Override
    public void set(int index, T t) {
        rangeCheck(index);
        Link current = getLink(index);
        current.data = t;
    }

    private Link getLink(int index){
        Link current = first;
        if(index < size/2) {
            while (index > 0) {
                current = current.next;
                index--;
            }
        }else {
            current = last;
            index = size - index - 1;
            while ( index > 0) {
                current = current.previous;
                index--;
            }
        }
        return current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object ob) {
        Link current = first;

        while(!current.data.equals((T) ob)){
            if(current == null) return false;
            current = current.next;
        }

        return true;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void show() {
        System.out.print("LinkedList: ");
        Link current = first;
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
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

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>(){

            Link current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                Link temp = current;
                current = current.next;
                return (T) temp.data;
            }

            @Override
            public void remove() {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                current = current.previous;
            }
        };
        return iterator;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        @SuppressWarnings("unchecked")
        final int size = this.size;
        for (int i=0; i < size; i++) {
            action.accept(get(i));
        }
    }

    class Link{
        public Object data;
        public Link previous;
        public Link next;

        public Link(Object data) {
            this.data = data;
            previous = null;
            next = null;
        }

        @Override
        public String toString(){
            return (data + " ");
        }
    }
/*
    class Iterator<T>{

        Link current;
        Link previous;
        DoublyLinkedList ourList;

        public Iterator(DoublyLinkedList list) {
            ourList = list;
            reset();
        }

        public void reset() {
            current = ourList.first;
            previous = null;
        }

        public void nextLink() {
            previous = current;
            current = current.next;
        }

        public Link getCurrent() {
            return current;
        }

        public boolean atEnd() {
            return (current.next == null);
        }

        public void insertAfter(T data) {
            Link newLink = new Link(data);
            if(ourList.isEmpty()){
                ourList.first = newLink;
                current = newLink;
            }else{
                newLink.next = current.next;
                current.next = newLink;
                nextLink();
            }
        }

        public void insertBefore(T data) {
            Link newLink = new Link(data);

            if(previous == null){
                newLink.next = ourList.first;
                ourList.first = newLink;
                reset();
            }else{
                newLink.next = previous.next;
                previous.next = newLink;
                current = newLink;
            }
        }

        public T deleteCurrent(){
            Link temp = current;
            if(previous == null){
                ourList.first = current.next;
                ourList.first.previous = null;
                reset();
            }else{
                previous.next = current.next;
                if(atEnd()){
                    reset();
                }else{
                    current = current.next;
                }
            }
            return (T) temp.data;
        }

    }*/

}
