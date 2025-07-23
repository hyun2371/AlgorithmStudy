import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> output = new ArrayList<>();
        Map<String, Integer> map  = new HashMap<>();
        initMap(map);
        
        int mapNum =27, curInd = 0;
        
        while (curInd<msg.length()){
            String w = ""+msg.charAt(curInd); //현재 단어
            int nextInd = curInd+1;
            
            while (nextInd<=msg.length()&&map.containsKey(msg.substring(curInd,nextInd))){ // 단어가 사전에 있을 때까지
                w = msg.substring(curInd,nextInd);
                nextInd++;
            }
            
            output.add(map.get(w)); //사전에서 반환
            
            if (nextInd<=msg.length()){
                String wc = msg.substring(curInd,nextInd);
                map.put(wc,mapNum++);
            }
            curInd += w.length();
            
        }
        
        int[] answer = new int[output.size()];
        for (int i=0;i<output.size();i++){
            answer[i] = output.get(i);
        }
        return answer;
    }
    
    private static void initMap(Map<String, Integer> map){
        int mapInd=1;
        for (char ch = 'A';ch<='Z';ch++){
            map.put(String.valueOf(ch),mapInd++);
        }
    }
}
