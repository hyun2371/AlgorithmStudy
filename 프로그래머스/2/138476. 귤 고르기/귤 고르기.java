import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
       Map<Integer, Integer> stock = new HashMap<>(); // 크기, 재고
        
        for (int i=0;i<tangerine.length;i++){
            stock.put(tangerine[i],stock.getOrDefault(tangerine[i],0)+1);
        }
        
        List<Integer> cnt = new ArrayList<>(stock.values());
        Collections.sort(cnt,Collections.reverseOrder());

        int answer = 0;
        for (int x : cnt) {
            k -= x;
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}