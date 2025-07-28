import java.util.*;
class Solution {
    public int[] solution(String s) {

        String[] sArr = s.replace("{","").replace("}","").split(",");
        Map<String, Integer> map = new HashMap<>();
        for (String x : sArr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        
        int[] answer = new int[map.size()];
        int ind = map.size()-1;

        for (Map.Entry<String, Integer> entry : entryList) {
			answer[ind--] = Integer.parseInt(entry.getKey());
		}

        return answer;
    }
}