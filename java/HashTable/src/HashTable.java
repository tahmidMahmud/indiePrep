public class HashTable {

    private String[] table;
    private HashFunction function;
    private int collision = 0;
    private int numberOfEntries = 0;


    public HashTable(int size){
        table = new String[size];

        function = new HashFunction() {
            @Override
            public int hash(String string, int sizeOfHashTable) {
                return string.charAt(0) - 97;
            }
        };
    }

    private int hashfunction(String stringToHash){
        return function.hash(stringToHash, table.length);
    }

    public void insert(String string){
        int index = hashfunction(string);

        while(table[index] != null && numberOfEntries < table.length){
            index++;
            collision++;
            if(index == table.length){
                index %= table.length;
            }
        }

        table[index] = string;
        numberOfEntries++;

    }

    public int find(String string){
        int index = hashfunction(string);
        if(table[index] == string){
            return index;
        }
        for(int i = index+1; i%table.length != index%table.length; i++){
            if(table[i%table.length] == string){
                return i%table.length;
            }
        }
        return -1;
    }

    public void setHashFunction(HashFunction newFunction){ function = newFunction;}

    public String[] getTable(){ return table; }

    public int numberOfCollisions(){ return collision; }
}
