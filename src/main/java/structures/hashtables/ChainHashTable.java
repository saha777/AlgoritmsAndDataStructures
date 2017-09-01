package structures.hashtables;

public class ChainHashTable {
    private SortedList[] hashArray;
    private int arraySize;

    public ChainHashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for(int j=0; j<arraySize; j++)
            hashArray[j] = new SortedList();
    }

    public void displayTable()
    {
        for(int j=0; j<arraySize; j++)
        {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key)
    {
        return key % arraySize;
    }

    public void insert(Link theLink)
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key)
    {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key)
    {
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }

    class Link{
        private int iData;
        public Link next;

        public Link(int it){
            this.iData = it;
        }

        public int getKey(){
            return iData;
        }

        @Override
        public String toString(){
            return iData+" ";
        }
    }

    class SortedList{
        private Link first;

        public SortedList() {
            first = null;
        }

        public void insert(Link link){
            int key = link.getKey();
            Link previous = null;
            Link current = first;

            while( current != null && key > current.getKey() )
            {
                previous = current;
                current = current.next;
            }
            if(previous == null)
                first = link;
            else
                previous.next = link;
            link.next = current;
        }

        public void delete(int key){
            Link previous = null;
            Link current = first;

            while( current != null && key != current.getKey() )
            {
                previous = current;
                current = current.next;
            }

            if(previous == null)
                first = first.next;
            else
                previous.next = current.next;
        }

        public Link find(int key)
        {
            Link current = first;

            while(current != null && current.getKey() <= key)
            {
                if(current.getKey() == key)
                    return current;
                current = current.next;
            }

            return null;
        }

        public void displayList()
        {
            System.out.print("List (first-->last): ");
            Link current = first;
            while(current != null)
            {
                System.out.print(current.toString());
                current = current.next;
            }
            System.out.println("");
        }
    }
}
