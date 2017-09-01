package structures.trees._234;

public class DataItem<T extends Number> implements Comparable<T>{

    private T data;

    public DataItem(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public int compareTo(T o) {
        if(data.doubleValue() < o.doubleValue())
            return 1;
        else if(o == data)
            return 0;
        return -1;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "data=" + data +
                '}';
    }
}
