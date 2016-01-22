public class SortFunctions {

    public static void insertionSort(int[] array) {
        for(int j = 1; j < array.length; j++){
            int key = array[j];
            int i = j - 1;
            while(i >=0 && array[i] > key){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }

    public static void mergeSort(int[] array, int p, int r) {
        if(p < r){
            int q = (int) Math.floor((p+r)/2);
            mergeSort(array, p, q);
            mergeSort(array, q+1, r);
            merge(array, p, q, r);
        }
    }

    private static void merge(int[] array, int p, int q, int r) {
        int n1 = q-p+1;
        int n2 = r-q;

        int[] lowerHalf = new int[n1+1];
        int[] highHalf = new int[n2+1];

        int k = p;
        for(int i = 0; i < n1; i++){
            lowerHalf[i] = array[k];
            k++;
        }
        for(int j = 0; j < n2; j++){
            highHalf[j] = array[k];
            k++;
        }

        lowerHalf[n1] = Integer.MAX_VALUE;
        highHalf[n2] = Integer.MAX_VALUE;

        k = p;
        int i = 0;
        int j = 0;
        while(k <= r){
            if(lowerHalf[i] < highHalf[j]){
                array[k] = lowerHalf[i];
                i++;
            }else{
                array[k] = highHalf[j];
                j++;
            }
            k++;
        }
    }
}
