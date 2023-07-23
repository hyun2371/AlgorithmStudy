import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> lst = new ArrayList<>();
        
        for (int i =l;i<=r;i+=1){
            boolean b = true;
            for (char c :String.valueOf(i).toCharArray()){
                if (!(c=='5'||c=='0')){
                    b = false; break;
                }
            }
            if (b) lst.add(i);
        }
        
        if (lst.isEmpty()) return new int[]{-1};
        return lst.stream().mapToInt(x->x).toArray();
    }
}