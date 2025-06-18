import java.util.*;
class Solution {
    public int[] solution(String s) {
        int tries = 0, zeroCnt = 0;
        
        while (true){
            zeroCnt+=getZeroCnt(s);
            s = s.replace("0","");
            s = toBinaryString(s.length());
            tries++;
            if (s.equals("1")) break;
        }
        
        return new int[]{tries,zeroCnt};
    }
    
    private static int getZeroCnt(String s){
        int cnt = 0;
        for (char c : s.toCharArray()){
            if (c=='0')
                cnt++;
        }
        return cnt;
    }
    
    private static String toBinaryString(int n){
        StringBuilder sb = new StringBuilder();
        while (n!=0){
            sb.append(n%2);
            n/=2;
        }
        return sb.reverse().toString();
    }
}