import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Rate> rates = new ArrayList<>();
        double failRate;
        
        int[] stopCnt = new int[N+2];
        for (int stage:stages){
            stopCnt[stage]++;
        }
        System.out.println(Arrays.toString(stopCnt));
        
        int visitCnt = stages.length;
        for (int i=1;i<=N;i++){
            if (visitCnt==0) failRate = 0;
            else failRate = (double)stopCnt[i]/visitCnt;
            rates.add(new Rate(i,failRate));
            visitCnt-=stopCnt[i];
        }
        Collections.sort(rates);
        
        int[] answer = new int[N];
        for (int i=0;i<rates.size();i++){
            answer[i] = rates.get(i).stageNo;
        }
        
        return answer;
    }
}
class Rate implements Comparable<Rate>{
    int stageNo;
    double failRate;
    
    public Rate(int stageNo, double failRate){
        this.stageNo = stageNo;
        this.failRate = failRate;
    }
    
    public int compareTo(Rate o){
        if (o.failRate==this.failRate)
            return this.stageNo-o.stageNo;
        return Double.compare(o.failRate, this.failRate);

    }
}