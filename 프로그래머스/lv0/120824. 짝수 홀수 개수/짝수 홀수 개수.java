import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int a = (int)Arrays.stream(num_list).filter(x->x%2==0).count();
        int b = (int)Arrays.stream(num_list).filter(x->x%2!=0).count();
        return new int[]{a,b};
    }
}