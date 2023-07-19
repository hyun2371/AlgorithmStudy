import java.util.*;
class Solution {
    public String solution(String polynomial) {
        int a =0, b=0; //x계수, 상수항
        
        //a,b
        for (String s: polynomial.split(" ")){
            if (s.equals("+")) continue;
            
            if (s.equals("x")) a+=1;
            else if ((s.charAt(s.length()-1))=='x'){
                a+=Integer.parseInt(s.substring(0,s.length()-1));
            } else {
                b+=Integer.parseInt(s);
            }
        }
        
        //값 반환
        if (a==0) return String.valueOf(b);
        else if (b==0){
            if (a==1) return "x";
            return a+"x";
        } else {
            if (a==1) return "x + "+b;
            return a+"x + "+b;
        }
    }
}