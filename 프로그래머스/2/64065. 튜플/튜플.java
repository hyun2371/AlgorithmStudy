import java.util.*;
class Solution {
    public int[] solution(String s) {

        String[] sArr = s.replace("{","").replace("}","").split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String x : sArr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        int[] answer = new int[map.size()];
        for (String key: map.keySet()) {
			answer[map.size()-map.get(key)] = Integer.parseInt(key);
		}

        return answer;
    }
}