package structures.trees._234;

public class Node<T extends Number> {

    private final int ORDER = 4;
    private int numItems = 0;
    private Node<T> parent;
    private Node<T>[] childArray = new Node[ORDER];
    private DataItem<T>[] itemArray = new DataItem[ORDER-1];

    public void connectChild(int childNum, Node<T> child){
        childArray[childNum] = child;
        if(child != null){
            child.parent = this;
        }
    }

    public Node<T> disconnectChild(int childNum){
        Node<T> node = childArray[childNum];
        childArray[childNum] = null;
        return node;
    }

    public Node<T> getChild(int childNum){
        return childArray[childNum];
    }

    public Node<T> getParent(){
        return parent;
    }

    public boolean isLeaf(){
        return childArray[0] == null;
    }

    public int getNumItems(){
        return numItems;
    }

    public DataItem<T> getItem(int index){
        return itemArray[index];
    }

    public boolean isFull(){
        return numItems == 3;
    }

    public int findItem(T key){
        for(int i = 0; i < numItems; i++){
            if(itemArray[i] == null){
                break;
            }
            else if(key.equals(itemArray[i].getData())){
                return i;
            }
        }
        return -1;
    }

    public int insertItem(DataItem<T> newItem){
        numItems++;
        for (int j = ORDER-2; j >= 0; j--){
            if(itemArray[j] == null){
                continue;
            }
            else {
                if(newItem.compareTo(itemArray[j].getData()) < 0){
                    itemArray[j+1] = itemArray[j];
                }else{
                    itemArray[j+1] = newItem;
                    return j+1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public DataItem<T> removeItem(){
        DataItem<T> item = itemArray[numItems-1];
        itemArray[--numItems] = null;
        return item;
    }

    public void displayNode(){
        for(int j=0; j < numItems; j++)
            System.out.println(itemArray[j]);
        System.out.println();
    }

}
