public class List<T> {

    private T data;
    private List<T> next;
    private int size;

    public boolean hasNext(){
        return next != null;
    }

    public  void add(T newData) {
        List<T> temp = this;
        while (temp.hasNext()){
            temp = temp.next;
        }
        temp.next = new List<>();
        temp.next.data = newData;
        size++;
    }

    public void add(T newData, int index) {
        List<T> temp = this;
        int i = 0;
        while (temp.hasNext() && i < index){
            temp = temp.next;
            i++;
        }
        List<T> newNode = new List<>();
        newNode.data = newData;
        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    public int size() {
        return size;
    }

    public String toString(){
        String list = "";
        List<T> temp = this;
        while(temp.hasNext()){
            temp = temp.next;
            list = list + " " + temp.data.toString();
        }
        return list.substring(1);
    }

    public void remove(int index) {
        List<T> temp = this;
        int i = 0;
        while (temp.hasNext() && i < index){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        size--;
    }

    public T get(int index) {
        List<T> temp = this;
        int i = 0;
        while (temp.hasNext() && i < index){
            temp = temp.next;
            i++;
        }
        return temp.next.data;
    }

    public List<T> sort(){

        for(int i = 0; i < size-1; i++){
            for(int j = i+1; j < size; j++){
                T iData  = get(i);
                T jData  = get(j);
                if((Integer)iData > (Integer)jData) {
                    add(iData, j+1);
                    remove(j);
                    add(jData, i+1);
                    remove(i);
                }
            }
        }
        return this;
    }
}
