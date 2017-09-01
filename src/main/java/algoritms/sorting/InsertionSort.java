package algoritms.sorting;


public class InsertionSort {

    long[] array = {10, 3, 7, 11, 25, 2, 6};

    public InsertionSort(){
        insertionSort();
    }

    public static void main(String[] args) {
        new InsertionSort();
    }

    public void insertionSort(){
        int in, out;

        for(out = 1; out < array.length; out++){
            long temp = array[out];
            in = out;

            while(in > 0 && temp <= array[in-1]){
                array[in] = array[in-1];
                --in;
            }

            array[in] = temp;
        }

    }

    private void swap(int a, int b){
        long c = array[a];
        array[a] = array[b];
        array[b] = c;
    }

    public void show(){
        for(long a : array)
            System.out.print(a + " ");
        System.out.println();
    }
}
