import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt = new int[3];
        for (int i=0;i<answers.length;i++){
            if (arr1[i%arr1.length]==answers[i]) cnt[0]++;
            if (arr2[i%arr2.length]==answers[i]) cnt[1]++;
            if (arr3[i%arr3.length]==answers[i]) cnt[2]++;
        }
        
        List<Integer> lst = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i=0;i<cnt.length;i++){
            if (cnt[i]==max) lst.add(i+1);
            else if (cnt[i]>max){
                max = cnt[i];
                lst.clear();
                lst.add(i+1);
            }
        }
        
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }
}