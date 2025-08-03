import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(); //1단계
        for (char c : new_id.toCharArray()){//2단계
            if (isValid(c)) answer+=c;
        }

        //3단계
        while (answer.contains("..")){
            answer = answer.replace("..", ".");
        }

        //4단계
        if (answer.length()>=2&&answer.startsWith("."))
            answer = answer.substring(1);
        if (answer.length()>=1&&answer.endsWith("."))
            answer = answer.substring(0,answer.length()-1);
        
        //5단계
        if (answer.equals("")) answer = "a";
           
        //6단계
        if (answer.length()>15){ 
            answer = answer.substring(0,15);
        }
        if (answer.length()>=1&&answer.endsWith("."))
            answer = answer.substring(0,answer.length()-1);
        
        //7단계
        while (answer.length()<=2){ 
            answer+=answer.charAt(answer.length()-1);
        }
        
        return answer;
    }
    
    private static boolean isValid(char c){
        if (c>='0'&&c<='9') return true;
        if (c>='a'&&c<='z') return true;
        if (c=='-'||c=='_'||c=='.') return true;
       return false;
    }
}