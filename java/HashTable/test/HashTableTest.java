import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

public class HashTableTest {

    HashTable hashTable;
    String[] testArray;
    final int SIZE = 30;

    @Before
    public void initialize(){
        hashTable = new HashTable(SIZE);
        testArray = new String[SIZE];
    }

    @Test
    public void canary(){
        assertTrue(true);
    }

    @Test
    public void insertAnItemToHashTable(){
        hashTable.insert("f");

        testArray[5] = "f";

        Assert.assertArrayEquals(hashTable.getTable(), testArray);
    }

    @Test
    public void fillHashTableWithAs(){

        for(int i = 0; i < SIZE; i++){
            hashTable.insert("a");
            testArray[i] = "a";
        }



        Assert.assertArrayEquals(hashTable.getTable(), testArray);
    }
}
