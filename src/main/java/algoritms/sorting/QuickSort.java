package algoritms.sorting;


public class QuickSort {

    long[] array = {10, 3, 7, 11, 25, 2, 6};

    public QuickSort(){
        recQuickSort(0, array.length - 1);
    }

    public static void main(String[] args) {
        new QuickSort();
    }

    public void recQuickSort(int start, int end){
        if(end-start <= 0) return;

        int partition = partitionIt(start, end, array[end]);

        recQuickSort(start, partition - 1);
        recQuickSort(partition + 1, end);
    }

    public int partitionIt(int start, int end, long pivot){
        int left = start - 1;
        int right = end;

        while(true){
            while(pivot > array[++left]);
            while(pivot < array[--right] && right > 0);
            if(left >= right)break;
            swap(left, right);
        }

        swap(left, end);
        return left;
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
