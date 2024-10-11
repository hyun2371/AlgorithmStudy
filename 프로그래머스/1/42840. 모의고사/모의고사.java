import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1,2,3,4,5};  // 찍는 번호
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt = new int[3]; // 맞춘 횟수
        
        // 맞춘 횟수 세기
        for (int i=0;i < answers.length;i++){
            if (s1[i%s1.length]==answers[i]) cnt[0]++;
            if (s2[i%s2.length]==answers[i]) cnt[1]++;
            if (s3[i%s3.length]==answers[i]) cnt[2]++;
        }
        
        // 최다득점자 구하기
        String max_s_str = "";
        int max = Arrays.stream(cnt).max().getAsInt(); //최고 점수
     
        for (int i=0;i<cnt.length;i++){
            if (cnt[i]==max){ // 동점자
                max_s_str+=(i+1); // 사람(인덱스) 저장
            }
        }
        
        // 최다득점자 문자열 -> int[]
        int[] answer = new int[max_s_str.length()]; int answerInd=0;
        for (char ind : max_s_str.toCharArray()){
            answer[answerInd++] += ind-'0';
        }

        return answer;
    }
}