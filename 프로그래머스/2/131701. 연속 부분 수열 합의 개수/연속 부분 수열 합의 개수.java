import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        for (int k=1;k<=len;k++){//구간 길이
            for (int i=0;i<len;i++) { //시작점
                int sum = 0;
                for (int j=i;j<i+k;j++){
                    int ind = (j+1)%len;
                    sum+=elements[ind];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}