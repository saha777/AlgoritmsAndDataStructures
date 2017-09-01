package structures.lists;

public interface List<T> extends Iterable<T>, Checkable {
    void insertFirst(T t);
    void insertLast(T t);
    void insert(int index, T t);
    T deleteFirst();
    T deleteLast();
    T delete(int index);
    T getFirst();
    T getLast();
    T get(int index);
    void setFirst(T t);
    void setLast(T t);
    void set(int index, T t);
    int size();
    boolean contains(Object ob);
    boolean isEmpty();
    void show();
    long getNanoTime();
}
