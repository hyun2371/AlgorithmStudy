import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       String s = sc.next();
       int[] cnt = new int[10]; //0~9
       for (char c : s.toCharArray()){
           if (c=='6'||c=='9'){
               if (cnt[6]>cnt[9]) cnt[9]++;
               else cnt[6]++;
           }
          else cnt[c-'0']++;
       }
       Arrays.sort(cnt);
       System.out.print(cnt[9]);
    }
}