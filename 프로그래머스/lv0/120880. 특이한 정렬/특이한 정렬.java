import java.util.*;
import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] arr = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){
                if (Math.abs(n1-n)>Math.abs(n2-n)) return 1;
                else if (Math.abs(n2-n)>Math.abs(n1-n)) return -1;
                else return -n1.compareTo(n2);
            }
        });
        return Arrays.stream(arr).mapToInt(x->x).toArray();
    }
}