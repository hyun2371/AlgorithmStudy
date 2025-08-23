import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for (int i=0;i<players.length;i++){
            rank.put(players[i],i);
        }
        
        for (String target:callings){
            int targetIdx = rank.get(target);
            String front = players[targetIdx-1];
            
            rank.put(target,targetIdx-1);
            rank.put(front,targetIdx);
            
            players[targetIdx] = front;
            players[targetIdx-1] = target;
        }
        return players;
    }
}