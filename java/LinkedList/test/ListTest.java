import org.junit.Test;

import static junit.framework.Assert.*;

public class ListTest {

    @Test
    public void canary(){
        assertTrue(true);
    }

    @Test
    public void hasNextFalse(){
        List<Integer> list  = new List<>();

        assertFalse(list.hasNext());
    }

    @Test
    public void hasNextTrue(){
        List<Integer> list  = new List<>();
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
        List<Integer> list = new List<>();
        list.add(2);
        list.add(5);
        list.add(5);

        assertEquals(list.size(), 3);
    }

    @Test
    public void listToString(){
        List<Integer> list = new List<>();
        list.add(2);
        list.add(5);
        list.add(5);

        assertEquals(list.toString(), "2 5 5");
    }

    @Test
      public void addAtMiddleIndex(){
        List<Integer> list = new List<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3, 2);

        assertEquals(list.toString(), "0 1 3 2");
    }

    @Test
    public void addAtFirstIndex(){
        List<Integer> list = new List<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3, 0);

        assertEquals(list.toString(), "3 0 1 2");
    }

    @Test
    public void addAtLastIndex(){
        List<Integer> list = new List<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3, 3);

        assertEquals(list.toString(), "0 1 2 3");
    }

    @Test
    public void remove(){
        List<Integer> list = new List<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.remove(1);

        assertEquals(list.toString(), "0 2");
    }

}
