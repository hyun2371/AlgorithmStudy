import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        //스테이지별 잔류 횟수 구하기
        int[] cnts = new int[N+2]; //1-based 1~N+1
        for (int x : stages) cnts[x]++;
    
        //스테이지별 실패율 구하기
        List<Failure> failures = new ArrayList<>();
        int total = stages.length;
        
        for (int i=1;i<=N;i++){ 
            if (total==0){
                failures.add(new Failure(i,0));
                continue;
            }
            double percent = cnts[i]*1.0/total;
            failures.add(new Failure(i,percent));

            total-=cnts[i];
        }
        
        int[] answer = new int[N];
        
        Collections.sort(failures);
        for (int i=0;i<N;i++){
            Failure failure = failures.get(i);
            answer[i] = failure.stage;
        }

        return answer;
    }
}

class Failure implements Comparable<Failure>{
    int stage;
    double percent;
    
    public Failure(int stage, double percent){
        this.stage = stage;
        this.percent = percent;
    }
    
    @Override
    public int compareTo(Failure o){
        if (this.percent!=o.percent){
            return Double.compare(o.percent, this.percent);
        }
        return this.stage-o.stage;
    }
}