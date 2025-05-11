import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        
        for (String curP: callings){
            int rank = map.get(curP); //추월 플레이어 순위 얻기
            String frontP = players[rank-1];
             // 추월    
            map.put(curP, rank-1); 
            players[rank-1] = curP;
            //뒤로 밀림
            map.put(frontP, rank);        
            players[rank] = frontP;
        }
        
        String[] answer = new String[players.length];
        for (String s : map.keySet()){
            answer[map.get(s)] = s;
        }
        
        return answer;
    }
}