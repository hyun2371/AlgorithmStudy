import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        
        //0부터 진법 변환해서 더하기
        String total = ""; int num = 0;
        while (total.length()<=m*t){
            total+= Integer.toString(num++,n).toUpperCase();
        }
        
        //순서에 맞는 숫자 구하기
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<t;i++){
            sb.append(total.charAt(m*i+p-1));
        }

        return sb.toString();
    }
}