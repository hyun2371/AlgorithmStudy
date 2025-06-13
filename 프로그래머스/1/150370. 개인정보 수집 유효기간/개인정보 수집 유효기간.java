import java.util.*;
class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> lst = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
        String[] t = today.split("\\.");
        int todayDays = toDays(
            Integer.parseInt(t[0]),
            Integer.parseInt(t[1]),
            Integer.parseInt(t[2])
        );
      
        // 약관별 유효 개월 수
        for (int i=0;i<terms.length;i++){
            String[] term = terms[i].split(" ");
            map.put(term[0].charAt(0),Integer.valueOf(term[1]));
        }
        
        for (int i=0;i<privacies.length;i++){
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");
            int plusMonth = map.get(privacy[1].charAt(0));
            
            int expireDays = toDays(
                Integer.parseInt(date[0]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[2])     
            );
            
            expireDays+=plusMonth*28-1;
            
            if (expireDays<todayDays){//만료
                lst.add(i+1);
            }
        }
        int[] answer = new int[lst.size()];
        for (int i=0;i<answer.length;i++){
            answer[i] = lst.get(i);
        }
    
        return answer;
    }
    
    
   private int toDays(int y, int m, int d) {
        return y * 12 * 28 + (m-1) * 28 + d;
    }
}