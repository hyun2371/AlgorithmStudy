import java.util.*;
class Solution {
    static final int FULL_TIME = 23*60+59;
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTime = new TreeMap<>();
        
        for (int i=0;i<records.length;i++){
            String record = records[i];
            int time = FULL_TIME-getTime(record.split(" ")[0]);
            String key = record.split(" ")[1];
            String status = record.split(" ")[2];
            
            if (status.equals("IN")){
                totalTime.merge(key,time, Integer::sum
);
            } else {
                totalTime.merge(key,-time, Integer::sum
);
            }
        }
        
        int[] answer = new int[totalTime.size()];
        int ind = 0;
        for (String key: totalTime.keySet()){
            answer[ind++] = calculateFee(totalTime.get(key),fees);
        }
        return answer;
    }
    
    private int getTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        return 60*h+m;
    }

    private int calculateFee(int min, int[] fees){
        if (min<=fees[0]) return fees[1];
        return fees[1]+(int) Math.ceil((min-fees[0])/(double)fees[2])*fees[3];
    }
}