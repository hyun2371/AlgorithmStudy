import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        int answer = Integer.MAX_VALUE;
     
        for (int i=0;i<=n;i++){
            int remain = n-5*i;
            if (remain<0||remain%2!=0) continue;
            
            int tmp = i+remain/2;
            answer = Math.min(tmp,answer);
        }

        if (n%2!=0&&n<5) answer = -1; //2,5로 구성불가
        System.out.println(answer);
    }
}