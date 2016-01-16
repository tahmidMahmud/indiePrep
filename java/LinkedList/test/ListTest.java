import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ListTest {
    List<Integer> list;

    @Before
    public void initialize(){
        list = new List<>();
    }

    @Test
    public void canary(){
        assertTrue(true);
    }

    @Test
    public void hasNextFalse(){

        assertFalse(list.hasNext());
    }

    @Test
    public void hasNextTrue(){
        list.add(2);

        assertTrue(list.hasNext());
    }

    @Test
    public void size(){
        List<Integer> list = new List<>();
        list.add(2);

        assertEquals(list.size(), 1);
    }

    @Test
    public void sizeEquals3(){
        list.add(2);
        list.add(5);
        list.add(5);

        assertEquals(list.size(), 3);
    }

    @Test
    public void listToString(){
        list.add(2);
        list.add(5);
        list.add(5);

        assertEquals(list.toString(), "2 5 5");
    }

    @Test
      public void addAtMiddleIndex(){
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3, 2);

        assertEquals(list.toString(), "0 1 3 2");
    }

    @Test
    public void addAtFirstIndex(){
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3, 0);

        assertEquals(list.toString(), "3 0 1 2");
    }

    @Test
    public void addAtLastIndex(){
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3, 3);

        assertEquals(list.toString(), "0 1 2 3");
    }

    @Test
    public void remove(){
        list.add(0);
        list.add(1);
        list.add(2);
        list.remove(1);

        assertEquals(list.toString(), "0 2");
    }

    @Test
    public void get(){
        list.add(0);
        list.add(1);
        list.add(2);

        assertEquals((int)list.get(1), 1);
    }

}
