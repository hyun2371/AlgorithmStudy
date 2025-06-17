import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int cnt =0;
        for (int i=x;i<=y;i++){
            if (isPalindrome(String.valueOf(i))) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isPalindrome(String num){
        int lt = 0, rt = num.length()-1;
        while (lt<rt){
            if (num.charAt(lt)!=num.charAt(rt)) return false;
            lt++; rt--;
        }
        return true;
    }
}