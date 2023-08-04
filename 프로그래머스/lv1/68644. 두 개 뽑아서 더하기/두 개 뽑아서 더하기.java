import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> lst = new ArrayList<>();
        for (int i=0;i<numbers.length;i++){
            for (int j=0;j<numbers.length;j++){
                if (i==j) continue;
                int sum = numbers[i]+numbers[j];
                if (!lst.contains(sum))
                    lst.add(sum);
            }
        }
        Collections.sort(lst);
        return lst.stream().mapToInt(x->x).toArray();
    }
}