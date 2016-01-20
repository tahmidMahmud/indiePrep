public class BidirectionalLinkedList<T> {

    private T data;
    private BidirectionalLinkedList<T> next;
    private BidirectionalLinkedList<T> previous;

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevious() {
        return previous != null;
    }

    public void add(T newData) {
        BidirectionalLinkedList<T> newNode = new BidirectionalLinkedList<>();
        newNode.data = newData;
        previous = newNode;

        BidirectionalLinkedList<T> temp = this;
        while(temp.hasNext()){
            temp = temp.next;
        }

        newNode.previous = temp;


        temp.next = newNode;

    }

    public T get(int index) {
        BidirectionalLinkedList<T> temp = this;
        int i = 0;
        if(index >= 0) {
            while (temp.hasNext() && i <= index) {
                temp = temp.next;
                i++;
            }
        } else{
            while (temp.hasPrevious() && i > index) {
                temp = temp.previous;
                i--;
            }

        }
        return temp.data;
    }

    public void remove(int index) {
        BidirectionalLinkedList<T> temp = this;
        int i = 0;
        if(index >= 0) {
            while (temp.hasNext() && i <= index) {
                temp = temp.next;
                i++;
            }
            BidirectionalLinkedList<T> previous = temp.previous;
            BidirectionalLinkedList<T> next = temp.next;
            previous.next = next;
            next.previous = previous;

        } else{
            while (temp.hasPrevious() && i > index) {
                temp = temp.previous;
                i--;
            }
            BidirectionalLinkedList<T> previous = temp.previous;
            BidirectionalLinkedList<T> next = temp.next;
            previous.next = next;
            next.previous = previous;
        }
    }

    public String toString(){
        String list = "";
        BidirectionalLinkedList<T> temp = this;
        while(temp.hasNext()){
            temp = temp.next;
            list = list + " " + temp.data.toString();
        }
        return list.substring(1);
    }
}
