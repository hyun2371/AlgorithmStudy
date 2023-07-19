import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i =0;i<quiz.length;i++){
            answer[i] = calculate(quiz[i]);
        }
        
        return answer;
    }
    
    public String calculate(String q){
        String[] q_arr = q.split(" ");

        int n1=Integer.parseInt(q_arr[0]), 
        n2 = Integer.parseInt(q_arr[2]), result=Integer.parseInt(q_arr[4]);

        if (q_arr[1].equals("+")){
            return (n1+n2==result)?"O":"X";
        } else {
            return (n1-n2==result)?"O":"X";
        }
    }
}