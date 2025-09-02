import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Rate> rates = new ArrayList<>();
        double failRate;
        for (int i=1;i<=N;i++){//단계
            int visitCnt =0, stopCnt = 0;
            for (int cnt: stages){
                if (cnt>=i) visitCnt++;
                if (cnt==i) stopCnt++;
            }
            if (visitCnt==0) failRate = 0;
            else failRate = (double)stopCnt/visitCnt;
            rates.add(new Rate(i,failRate));
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
        if (o.failRate>this.failRate) return 1;
        else return -1;
    }
}