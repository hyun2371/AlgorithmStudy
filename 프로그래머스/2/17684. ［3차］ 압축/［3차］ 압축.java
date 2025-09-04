import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public int[] solution(String msg) {
        initMap();
        List<Integer> lst = new ArrayList<>();
        
        int curIdx = 0, dictIdx = 27;
        while (curIdx<msg.length()){
            int nextIdx = curIdx+1;
            String w = ""+msg.charAt(curIdx);
            while (nextIdx<=msg.length()&&map.containsKey(msg.substring(curIdx,nextIdx))){
                w = msg.substring(curIdx, nextIdx);
                nextIdx++;
            }

            lst.add(map.get(w));
            if (nextIdx<=msg.length()){
                map.put(msg.substring(curIdx, nextIdx),dictIdx++);
            }
            curIdx +=w.length();
        }

        
        
        int[] answer = new int[lst.size()];
        for (int i=0;i<lst.size();i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
    
    static void initMap(){
        for (int i=0;i<26;i++){
            map.put(String.valueOf((char)('A'+i)),i+1);
        }
    }
}