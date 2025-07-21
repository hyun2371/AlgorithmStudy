import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {

        Map<String, Car> map = new TreeMap<>(); //차번호, 차
        for (String record: records){
            String[] data = record.split(" ");
            
            String time = data[0];
            int hour = Integer.valueOf(time.split(":")[0]);
            int min = Integer.valueOf(time.split(":")[1]);
            
            String carNum = data[1];
            String cmd = data[2];
            if (cmd.equals("IN")&&!map.containsKey(carNum)){
                map.put(carNum,new Car(hour,min)); continue;
            } 
            
            Car car = map.get(carNum);
            if (cmd.equals("OUT")){
                car.out(hour,min);
            }
            else {
                car.entry(hour,min);
            }
            
        }
        
        int[] answer = new int[map.size()];

        int defaultMin = fees[0];
        int defaultFee = fees[1];
        int overMin = fees[2];
        int overFee = fees[3];
        int idx = 0;
        for (Car car:map.values()){
            int totalTime = car.getTotalTime();
            if (totalTime<=defaultMin) answer[idx++] = defaultFee;
            else 
            answer[idx++] = defaultFee+
                (int)Math.ceil((totalTime-defaultMin*1.0)/overMin)*overFee;
        }
        
        return answer;
    }
}

class Car {
    boolean isEntry = false; //입차 여부
    int entryHour; //입차 시간
    int entryMin; //입차 분
    int totalTime = 0;
    
    public Car(int entryHour, int entryMin){ //최초 입차
        this.entryHour = entryHour;
        this.entryMin = entryMin;
        isEntry = true;
    }
    
    public void entry(int entryHour, int entryMin){//입차
        this.entryHour = entryHour;
        this.entryMin = entryMin;
        isEntry = true;
    }
    
    public void out(int outHour, int outMin){ //출차
        totalTime+= (outHour-entryHour)*60+(outMin-entryMin); //주차 시간 누적
        isEntry = false;
    }
    
    public int getTotalTime(){ //누적시간 반환
        if (isEntry){//아직 출차 안함
           totalTime+= (23-entryHour)*60+(59-entryMin);
        }
        return totalTime;
    }
}