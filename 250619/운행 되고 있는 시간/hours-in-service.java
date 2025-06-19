import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        
        int answer = Integer.MIN_VALUE;
        
        for (int i=0;i<N;i++){//제외할 인덱스
            int[] cntPerHour = new int[1001];
            int totalCnt = 0;
            for (int j=0;j<N;j++){ //탐색
                if (i==j) continue;
                for (int t=A[j];t<B[j];t++){
                    cntPerHour[t]++;
                }
            }
            for (int j=1;j<=1000;j++){
                if (cntPerHour[j]>0) totalCnt++;
            }
            answer = Math.max(answer,totalCnt);
        }
        System.out.println(answer);
    }
}