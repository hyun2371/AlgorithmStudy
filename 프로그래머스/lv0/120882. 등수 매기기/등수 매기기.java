import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avg = new double[score.length];
        
        //평균 구하기
        for (int i=0;i<score.length;i++){
            avg[i] = (score[i][0]+score[i][1])/2.0;
        }
        
        //평균 배열 복사해서 정렬
        double[] sorted_avg = Arrays.copyOf(avg,avg.length);
        Arrays.sort(sorted_avg);
        
        //역순 정렬
        double[] sorted_avg_rev = new double[avg.length];
        for (int i =0;i<sorted_avg.length;i++){
            sorted_avg_rev[i] = sorted_avg[sorted_avg.length-i-1];
        }
        
        //등수 매기기
        for (int i=0;i<avg.length;i++){
            int ind =0;
            while (avg[i]!=sorted_avg_rev[ind]){
                ind++;
            }
            answer[i] = ind+1;
        }
        return answer;
    }
}