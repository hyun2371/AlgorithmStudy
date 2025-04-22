import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = Integer.MAX_VALUE;
     
        for (int i=0;i<=n;i++){ // 5 구성 개수
            int remain = n-5*i; //5로 구성 
            if (remain<0) break;
            if (remain%2!=0) continue;
            int tmp = i+remain/2; // 나머지 2로 구성
            answer = Math.min(tmp,answer);
        }
        if (answer==Integer.MAX_VALUE) answer = -1; //2,5로 구성불가
        System.out.println(answer);
    }
}