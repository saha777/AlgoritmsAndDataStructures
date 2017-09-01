package algoritms.sorting;

public class ShellSort {

    long[] array = {10, 3, 7, 11, 25, 2, 6};

    public ShellSort(){
        shellSort();
        show();
    }

    public static void main(String[] args) {
        new ShellSort();
    }

    public void show(){
        for(long a : array){
            System.out.println(a+" ");
        }
    }

    public long[] shellSort(){
        int in, out;
        long temp;
        int h = 1;
        int nElems = array.length;

        while(h <= nElems/3){
            h = h * 3 + 1;
        }

        while(h > 0){
            for(out = h; out < nElems; out++){
                temp = array[out];
                in = out;

                while(in > h - 1 && array[in - h] >= temp){
                    array[in] = array[in - h];
                    in -= h;
                }

                array[in] = temp;
            }

            h = (h-1)/3;
        }
        return array;
    }
}
