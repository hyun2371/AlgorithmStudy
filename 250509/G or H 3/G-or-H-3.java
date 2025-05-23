import java.util.Scanner;
public class Main {
    static final int MAX_LEN = 10_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 인원 수
        int K = sc.nextInt(); // 사진 크기
        int[] scores = new int[MAX_LEN+1];
        
        for (int i = 0; i < N; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            scores[pos] = (c=='G')?1:2;
        }     
        int maxSum = 0;
        for (int i=1;i<=MAX_LEN-K;i++){
            int sum = 0;
            for (int j=i;j<=i+K;j++){
                sum+=scores[j];
            }
            maxSum = Math.max(sum,maxSum);
        }
        System.out.println(maxSum);
    }
}