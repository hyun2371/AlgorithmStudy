import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] arr) {
        /*
        2 나타나면 계속 더하기
        뒤에서부터 2 나타날 때까지 제거하기
        리스트 비었으면 -1로 바꾸기
        */
        boolean lock = true;
        List<Integer> lst = new ArrayList<>();
        for (int n : arr){
            if (n==2)
                lock=false;
            
            if (!lock)
                lst.add(n);
            
        }
        while (true){
            if (lst.isEmpty()) {
                return new int[]{-1};
            }
            if (lst.get(lst.size()-1)==2)
                break;
            lst.remove(lst.size()-1);
        }

        return lst.stream().mapToInt(x->x).toArray();
    }
}