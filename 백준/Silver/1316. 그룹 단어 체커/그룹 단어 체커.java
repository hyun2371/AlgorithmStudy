import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i=0;i<n;i++){
            String s = sc.next();
            if (isCheck(s)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean isCheck(String s){
        int[] alpha = new int[26];
        char cmp = '0';
        for (char c : s.toCharArray()){
            if (c==cmp)
                continue;
            alpha[c-'a']++;
            cmp = c;
        }
        for (int cnt : alpha){
            if (cnt>1)return false;
        }
        return true;
    }
}