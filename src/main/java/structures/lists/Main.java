package structures.lists;

import java.util.Random;

public class Main {

    List<Integer> linkedList;
    ArrayList<Integer> arrayList;

    Main(){
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();

        add();
        insert();
        remove();
        set();
        contain();
    }

    public static void main(String[] args){
        new Main();
        new Main();
    }

    public void add(){
        System.out.println();
        System.out.println("ADD");
        System.out.println();

        Random random = new Random();

        long tStart = linkedList.getNanoTime();

        for(int i = 0; i < 1000; i++){
            linkedList.insertLast(random.nextInt(200));
        }

        long tEnd = linkedList.getNanoTime();

        System.out.println("LinkedList: "+(tEnd-tStart));

        tStart = arrayList.getNanoTime();

        for (int i = 0; i < 1000; i++){
            arrayList.insertLast(random.nextInt(200));
        }

        tEnd = arrayList.getNanoTime();

        System.out.println("ArrayList: "+(tEnd-tStart));
        linkedList.show();
        arrayList.show();
    }

    public void insert(){
        System.out.println();
        System.out.println("INSERT");
        System.out.println();

        long tStart = linkedList.getNanoTime();

        linkedList.insertFirst(1000);
        linkedList.insertLast(1000);
        linkedList.insert(1000, 432);
        linkedList.insert(1000, 688);

        long tEnd = linkedList.getNanoTime();

        System.out.println("LinkedList: "+(tEnd-tStart));

        tStart = arrayList.getNanoTime();

        arrayList.insertFirst(1000);
        arrayList.insertLast(1000);
        arrayList.insert(1000, 432);
        arrayList.insert(1000, 688);

        tEnd = arrayList.getNanoTime();

        System.out.println("ArrayList: "+(tEnd-tStart));
        linkedList.show();
        arrayList.show();
    }

    public void remove(){
        System.out.println();
        System.out.println("REMOVE");
        System.out.println();

        long tStart = linkedList.getNanoTime();

        linkedList.deleteFirst();
        linkedList.deleteLast();
        linkedList.delete(244);
        linkedList.delete(525);

        long tEnd = linkedList.getNanoTime();

        System.out.println("LinkedList: "+(tEnd-tStart));

        tStart = arrayList.getNanoTime();

        arrayList.deleteFirst();
        arrayList.deleteLast();
        arrayList.delete(244);
        arrayList.delete(525);

        tEnd = arrayList.getNanoTime();

        System.out.println("ArrayList: "+(tEnd-tStart));
        linkedList.show();
        arrayList.show();
    }

    public void set(){
        System.out.println();
        System.out.println("SET");
        System.out.println();

        long tStart = linkedList.getNanoTime();

        linkedList.setFirst(1);
        linkedList.setLast(2);
        linkedList.set(3, 432);
        linkedList.set(4, 861);

        long tEnd = linkedList.getNanoTime();

        System.out.println("LinkedList: "+(tEnd-tStart));

        tStart = arrayList.getNanoTime();

        arrayList.setFirst(1);
        arrayList.setLast(2);
        arrayList.set(3, 432);
        arrayList.set(4, 861);

        tEnd = arrayList.getNanoTime();

        System.out.println("ArrayList: "+(tEnd-tStart));
        linkedList.show();
        arrayList.show();
    }

    public void contain(){
        System.out.println();
        System.out.println("CONTAINS");
        System.out.println();

        long tStart = linkedList.getNanoTime();

        int a = linkedList.get(499);
        linkedList.contains(a);

        long tEnd = linkedList.getNanoTime();

        System.out.println("499: "+a);
        System.out.println("LinkedList: "+(tEnd-tStart));

        tStart = arrayList.getNanoTime();

        a = arrayList.get(499);
        arrayList.contains(a);

        tEnd = arrayList.getNanoTime();

        System.out.println("499: "+a);
        System.out.println("ArrayList: "+(tEnd-tStart));
        linkedList.show();
        arrayList.show();
    }

}
