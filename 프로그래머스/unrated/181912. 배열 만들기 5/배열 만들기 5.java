import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        /*
        s~s+l까지 자른 후 숫자로 반환 
        k와 비교후 크면 배열에 담기
        */
        List<Integer> lst = new ArrayList<>();
        for (int i =0;i<intStrs.length;i++){
            int n = Integer.parseInt(intStrs[i].substring(s,s+l));
            if (n>k) lst.add(n);
        }
        return lst.stream().mapToInt(x->x).toArray();
        
    }
}