import java.util.*;
class Solution {
    public int solution(String dartResult) {
        List<String> darts = new ArrayList<>();
        splitDarts(dartResult, darts);
        
        int[] scores = new int[darts.size()];
        for (int i=0;i<darts.size();i++){
            String target = darts.get(i);

            int score = target.charAt(0)-'0';
            if (target.contains("10")) score = 10;

            scores[i] = (int)Math.pow(score,getBonus(target));

            if (target.contains("#")) scores[i]*=-1;
            else if (target.contains("*")){
                scores[i]*=2;
                if (i>0) scores[i-1]*=2;
            }
        }

        return getTotal(scores);
    }
    
    private static int getBonus(String target){
        if (target.contains("T")) return 3;
        if (target.contains("D")) return 2;
        return 1;
    }
    private static void splitDarts(String dartResult, List<String> darts){
        int tmp =0;
        for (int i=0;i<dartResult.length();i++){
            if (i!=0&&Character.isDigit(dartResult.charAt(i))){
                if (Character.isDigit(dartResult.charAt(i-1))) continue; //10고려
                darts.add(dartResult.substring(tmp,i));
                tmp = i;
            }
        }
        darts.add(dartResult.substring(tmp,dartResult.length()));
    }
    
    private static int getTotal(int[] scores){
        int total = 0;
        for (int x:scores){
            total+=x;
        }
        return total;
    }
}