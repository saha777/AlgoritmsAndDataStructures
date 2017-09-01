package algoritms.sorting;

public class MergeSort {
    long[] theArray = {10, 20, 3, 15, 25, 5};

    public MergeSort(){
        recMergeSort(new long[theArray.length], 0, theArray.length - 1);
        for(long a : theArray){
            System.out.print(a+" ");
        }
    }

    public static void main(String[] args) {
        new MergeSort();
    }

    public void recMergeSort(long[] workSpace, int lowerBound, int upperBound){
        if(lowerBound == upperBound){
            return;
        }
        else{
            int mid = (lowerBound+upperBound)/2;
            System.out.println(lowerBound+" "+mid+" "+upperBound);
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid+1, upperBound);
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    }

    public void merge(long[] workSpace, int lowPtr,
                      int highPtr, int upperBound){
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound - lowerBound + 1;

        while(lowPtr <= mid && highPtr <= upperBound){
            if(theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }

        while(lowPtr <= mid){
            workSpace[j++] = theArray[lowPtr++];
        }

        while(highPtr <= upperBound){
            workSpace[j++] = theArray[highPtr++];
        }

        for(j = 0; j < n; j++){
            theArray[lowerBound+j] = workSpace[j];
        }
    }
}
