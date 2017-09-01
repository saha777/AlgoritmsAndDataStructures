package structures.trees._234;

public class Tree234<T extends Number> {
    private Node<T> root = new Node();

    public int find(T key){
        Node<T> currentNode = root;
        int childNumber;
        while (true){
            if((childNumber = currentNode.findItem(key)) != -1)
                return childNumber;
            else if(currentNode.isLeaf())
                return -1;
            else
                currentNode = getNextChild(currentNode, key);
        }
    }

    public void insert(T value){
        Node<T> curNode = root;
        DataItem<T> tempItem = new DataItem(value);
        while(true){
            if(curNode.isFull()){
                split(curNode);

                curNode = curNode.getParent();
                curNode = getNextChild(curNode, value);
            }else if(curNode.isLeaf()){
                break;
            }else {
                curNode = getNextChild(curNode, value);
            }
        }
        curNode.insertItem(tempItem);
    }

    private void split(Node<T> thisNode){
        DataItem<T> itemB, itemC;
        Node<T> parent, child2, child3;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child3 = thisNode.disconnectChild(3);
        child2 = thisNode.disconnectChild(2);
        Node<T> newRight = new Node();

        if(thisNode == root){
            root = new Node<T>();
            parent = root;
            root.connectChild(0, thisNode);
        }
        else {
            parent = thisNode.getParent();
        }

        int itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for(int j = n - 1; j > itemIndex; j--){
            Node<T> temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);

    }

    private Node<T> getNextChild(Node<T> theNode, T value){
        int j;
        for(j = 0; j < theNode.getNumItems(); j++)
            if(theNode.getItem(j).compareTo(value) < 0)
                return theNode.getChild(j);
        return theNode.getChild(j);
    }

    public void displayTree()
    {
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node<T> thisNode, int level,
                                int childNumber)
    {
        System.out.println("level="+level+" child="+childNumber+" ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for(int j = 0; j < numItems + 1; j++)
        {
            Node<T> nextNode = thisNode.getChild(j);
            if(nextNode != null)
                recDisplayTree(nextNode, level+1, j);
            else
                return;
        }
    }
}
