import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][] d = new int[N][N];


        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        

        d[0][N-1] = arr[0][N-1];
         for (int i=N-2;i>=0;i--){
            d[0][i] = d[0][i+1]+arr[0][i]; // 1행
         }
         for (int i=1;i<N;i++){
            d[i][N-1] = d[i-1][N-1]+arr[i][N-1]; // N-1열
         }

        for (int i=0;i<N;i++){
            for (int j=N-1;j>=0;j--){
                if (d[i][j]!=0) continue;
                d[i][j] = Math.min(d[i-1][j],d[i][j+1])+arr[i][j];
            }
        }
        System.out.println(d[N-1][0]);
    }
}