import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
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

    @Test
    public void findWithoutCollision(){
        hashTable.insert("f");

        assertEquals(hashTable.find("f"), 5);
    }

    @Test
    public void findWithCollision(){
        hashTable.insert("art");
        hashTable.insert("ark");
        hashTable.insert("arm");

        assertEquals(hashTable.find("arm"), 2);
    }

    @Test
    public void numberOfCollisions(){
        hashTable.insert("art");
        hashTable.insert("ark");
        hashTable.insert("arm");
        hashTable.insert("ate");

        assertEquals(hashTable.numberOfCollisions(), 6);
    }

    @Test
    public void newHashFunction(){
        hashTable.setHashFunction(new HashFunction() {
            @Override
            public int hash(String string, int sizeOfHashTable) {
                int hashKeyValue = 0;
                for(int i = 0; i < string.length(); i++){
                    hashKeyValue = (hashKeyValue * 27 + (string.charAt(i)-97)) % sizeOfHashTable;
                }
                return hashKeyValue;
            }
        });

        hashTable.insert("art");
        hashTable.insert("ark");
        hashTable.insert("arm");
        hashTable.insert("ate");

        assertEquals(hashTable.numberOfCollisions(), 0);
    }




}
