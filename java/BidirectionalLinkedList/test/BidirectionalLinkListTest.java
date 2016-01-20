import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class BidirectionalLinkListTest {

    BidirectionalLinkedList<Integer> list;

    @Before
    public void initialize(){
        list = new BidirectionalLinkedList<>();
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
    public void hasPreviousFalse(){
        assertFalse(list.hasPrevious());
    }

    @Test
    public void hasNextTrue(){
        list.add(4);

        assertTrue(list.hasNext());
    }

    @Test
     public void hasPreviousTrue(){
        list.add(4);

        assertTrue(list.hasPrevious());
    }

    @Test
    public void getPositiveIndex(){
        list.add(4);
        list.add(5);
        list.add(6);

        assertEquals((int) list.get(0), 4);
    }

    @Test
    public void getNegativeIndex(){
        list.add(4);
        list.add(5);
        list.add(6);

        assertEquals((int) list.get(-2), 5);
    }

    @Test
     public void removePositiveIndex(){
        list.add(4);
        list.add(5);
        list.add(6);
        list.remove(1);

        assertEquals(list.toString(), "4 6");
    }

    @Test
    public void removeNegativeIndex(){
        list.add(4);
        list.add(5);
        list.add(6);
        list.remove(-2);

        assertEquals(list.toString(), "4 6");
    }
}
