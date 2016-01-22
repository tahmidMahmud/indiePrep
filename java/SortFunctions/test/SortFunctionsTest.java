import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class SortFunctionsTest {

    @Test
    public void canary(){
        assertTrue(true);
    }

    @Test
    public void insertionSortTest(){
        int[] array = {6, 7, 3, 4, 5, 8, 9, 2, 1, 0};
        SortFunctions.insertionSort(array);
        int[] trueValue = {0,1,2,3,4,5,6,7,8,9};

        assertArrayEquals(array, trueValue);
    }

    @Test
    public void mergeSortTest(){
        int[] array = {6, 7, 3, 4, 5, 8, 9, 2, 1, 0};
        SortFunctions.mergeSort(array, 0, array.length - 1);
        int[] trueValue = {0,1,2,3,4,5,6,7,8,9};

        assertArrayEquals(array, trueValue);
    }
}
