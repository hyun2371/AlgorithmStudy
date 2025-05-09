import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        int[] tmp = new int[M];
        int cnt = 0;

        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        Arrays.sort(B);

        for (int i=0;i<=N-M;i++){//시작점
            for (int j=0;j<M;j++){
                tmp[j] = A[i+j];
            }
            Arrays.sort(tmp);

            boolean isSame = true;
            for (int j=0;j<M;j++){
                if (tmp[j]!=B[j]){
                    isSame = false; break;
                }
            }
            if (isSame) cnt++;
        }
        System.out.println(cnt);
    }
}