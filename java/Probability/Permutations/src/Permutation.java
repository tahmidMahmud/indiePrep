import java.util.*;
import java.util.List;

public class Permutation {

    public static List<String> generateStringPermutations(String string){
        List<String> list = new ArrayList<>();
        permutation(" ", string, list);

        return list;
    }

    private static void permutation(String prefix, String string, List<String> list) {
        int n = string.length();
        if(n == 0){
            list.add(prefix);
        }else {
            for (int i = 0; i < n; i++){
                permutation(prefix + string.charAt(i), string.substring(0,i) + string.substring(i+1,n), list);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(generateStringPermutations("abc").toString());
    }
}
