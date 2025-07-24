import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> output = new ArrayList<>();
        initDict(dict);     
        int curIdx = 0, dictIdx=27;
        
        while (curIdx<msg.length()){
            int nextIdx = curIdx+1;
            String w = ""+msg.charAt(curIdx);
            while (nextIdx<=msg.length()&&dict.containsKey(msg.substring(curIdx,nextIdx))){          
                w = msg.substring(curIdx,nextIdx);
                nextIdx++;
            }
            output.add(dict.get(w)); // 기존 단어 찾기
            
            if (nextIdx<=msg.length()) 
                dict.put(msg.substring(curIdx,nextIdx),dictIdx++); //새로운 단어 추가
            curIdx += w.length();
        }
        
        int[] answer = new int[output.size()];
        for (int i=0;i<output.size();i++){
            answer[i] = output.get(i);
        }
        
        return answer;
    }
    
    private static void initDict(Map<String, Integer> dict){
        int dictIdx = 1;
        for (char c = 'A';c<='Z';c++){
            dict.put(c+"",dictIdx++);
        }
    }
}