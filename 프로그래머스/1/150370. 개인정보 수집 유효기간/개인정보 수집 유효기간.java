import java.util.*;
class Solution {
    static Map<Character, Integer> map = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> lst = new ArrayList<>();
        
        String[] todayArr = today.split("\\.");
        int ty = Integer.parseInt(todayArr[0]);
        int tm = Integer.parseInt(todayArr[1]);
        int td = Integer.parseInt(todayArr[2]);
        int todayTotal = getDayTotal(ty,tm,td,0);
      
        // 약관별 유효 개월 수
        for (int i=0;i<terms.length;i++){
            String[] term = terms[i].split(" ");
            map.put(term[0].charAt(0),Integer.valueOf(term[1]));
        }
        
        for (int i=0;i<privacies.length;i++){
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");
            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(date[2]);
            int plusMonth = map.get(privacy[1].charAt(0));
            
            int expireTotal = getDayTotal(y,m,d,plusMonth);
            if (expireTotal<todayTotal){//만료
                lst.add(i+1);
            }
            
        }
        int[] answer = new int[lst.size()];
        for (int i=0;i<answer.length;i++){
            answer[i] = lst.get(i);
        }
    
        return answer;
    }
    
    
    private static int getDayTotal(int y, int m, int d,int plusMonth){
        int total = 12*28*y+28*m+d;
        if (plusMonth>0){
            total+=28*plusMonth-1;
        }
        return total;
    }
}