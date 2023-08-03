import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        for (int i=0;i<numbers.length;i++){
            for (int j=0;j<numbers.length;j++){
                if (i==j) continue;
                lst.add(numbers[i]+numbers[j]);
            }
            
        }
        for (int i=0;i<lst.size();i++){
            if (lst.indexOf(lst.get(i))==i)
                ans.add(lst.get(i));
        }
        Collections.sort(ans);

        return ans.stream().mapToInt(x->x).toArray();
    }
}