package structures.hashtables;

public class DoubleHashTable {

    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public DoubleHashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable(){
        System.out.println("Table: ");
        for(int i = 0; i < arraySize; i++){
            if(hashArray[i] != null){
                System.out.print(hashArray[i].getKey() + " ");
            }else{
                System.out.print("** ");
            }
        }
        System.out.println();
    }

    public int hashFunc1(int key){
        return key % arraySize;
    }

    public int hashFunc2(int key){
        return 5 - key % 5;
    }

    public void insert(DataItem item){
        int key = item.getKey();
        int hashVal = hashFunc1(key);
        int stepVal = hashFunc2(key);

        while(hashArray[hashVal] != null || !hashArray[hashVal].equals(nonItem)){
            hashVal += stepVal;
            hashVal %= arraySize;
        }

        hashArray[hashVal] = item;
    }

    public DataItem delete(int key){
        int hashVal = hashFunc1(key);
        int stepVal = hashFunc2(key);

        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepVal;
            hashVal %= arraySize;
        }

        return null;
    }

    public DataItem find(int key){
        int hashVal = hashFunc1(key);
        int stepVal = hashFunc2(key);

        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal += stepVal;
            hashVal %= arraySize;
        }

        return null;
    }

    class DataItem{
        private int iData;

        public DataItem(int key) {
            this.iData = key;
        }

        public int getKey(){
            return iData;
        }
    }
}