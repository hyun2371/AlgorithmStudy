import java.util.*;
class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        
        for (int i=0;i<survey.length;i++){
            String s = survey[i];
            int score = choices[i]-4;
            calculate(s,score);
        }
        
        StringBuilder sb = new StringBuilder();
        char[] keys = {'R','T','C','F','J','M','A','N'};
        
        for (int i=0;i<keys.length-1;i+=2){
            char key1 = keys[i];
            char key2 = keys[i+1];
            int score1 = map.getOrDefault(key1,0);
            int score2 = map.getOrDefault(key2,0);
            if (score1>=score2) sb.append(key1);
            else if (score1<score2) sb.append(key2);
        }
        
        return sb.toString();
    }
    private static void calculate(String s, int score){
        if (score<0){
            char key = s.charAt(0);
            map.put(key,map.getOrDefault(key,0)+Math.abs(score));
        } else {
            char key = s.charAt(1);
             map.put(key,map.getOrDefault(key,0)+score);
        }
    }
}