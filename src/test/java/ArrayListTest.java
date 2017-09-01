import structures.lists.ArrayList;
import structures.lists.List;
import org.junit.Assert;
import org.junit.Test;

public class ArrayListTest {

    List<Integer> numbers;
    List<String> strings;

    public ArrayListTest(){
        numbers = new ArrayList<>();
        strings = new ArrayList<>();
    }

    @Test
    public void testInsert(){
        numbers.insertFirst(1);
        Assert.assertEquals(1, (int)numbers.getFirst());

        numbers.insertLast(3);
        if(numbers.getLast() != 3) Assert.fail();

        numbers.insert(1,2);
        if(numbers.get(1) != 2) Assert.fail();

        strings.insertFirst("1");
        if(!strings.getFirst().equals("1")) Assert.fail();

        strings.insert(1, "2");
        if(!strings.get(1).equals("2")) Assert.fail();

        strings.insertLast("3");
        if(!strings.getLast().equals("3")) Assert.fail();
    }

    @Test
    public void testSet(){
        for(int i = 0; i < 2; i++) {
            numbers.insertFirst(0);
            strings.insertFirst("a");
        }

        numbers.setFirst(1);
        if(numbers.getFirst() != 1) Assert.fail();

        numbers.setLast(3);
        if(numbers.getLast() != 3) Assert.fail();

        numbers.set(1, 2);
        if(numbers.get(1) != 2) Assert.fail();

        strings.setFirst("1");
        if(!strings.getFirst().equals("1")) Assert.fail();

        strings.set(1, "2");
        if(!strings.get(1).equals("2")) Assert.fail();

        strings.setLast("3");
        if(!strings.getLast().equals("3")) Assert.fail();
    }

    @Test
    public void testGet(){
        for(int i = 0; i < 3; i++) {
            numbers.insertFirst(3-i);
            strings.insertFirst(i+"");
        }

        if(numbers.getFirst() != 1) Assert.fail();

        if(numbers.getLast() != 3) Assert.fail();

        if(numbers.get(1) != 2) Assert.fail();

        if(!strings.getFirst().equals("2")) Assert.fail();

        if(!strings.get(1).equals("1")) Assert.fail();

        if(!strings.getLast().equals("0")) Assert.fail();
    }
}
