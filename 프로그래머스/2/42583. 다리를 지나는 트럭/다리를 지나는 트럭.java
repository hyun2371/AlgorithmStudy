import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //다리 초기화
        Queue<Integer> bridge = new LinkedList<>();
        for (int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }
        
        int ind = 0; //넣을 트럭
        int time = 0; //경과 시간
        int load_w = 0; // 다리 위 무게
        
        // 다 건너지 않았거나, 다리 위에 트럭 있을 때까지 반복
        while (ind<truck_weights.length||load_w>0){ 
            time++;
            load_w-=bridge.poll(); // 트럭 건넘 -> 무게 차감
            
            if (ind<truck_weights.length&&truck_weights[ind]<=weight-load_w){//현재 트럭 건널 수 있음
                bridge.offer(truck_weights[ind]);
                load_w+=truck_weights[ind++]; //트럭 올리기 -> 무게 증가
            }
            else bridge.offer(0); //현재 트럭 건널 수 없음
        }
        
        return time;
    }
}