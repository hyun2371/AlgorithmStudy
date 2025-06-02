import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] d = new int[N];
        if (N==1) {
            System.out.println(1); return;
        }
        d[0] = 1;

        for (int i=1;i<N;i++){
            int minInd = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j=0;j<i;j++){//i이전값들
                if (arr[j]>arr[i]&&arr[j]<minVal){
                    minInd = j;
                    minVal = arr[j];
                }
            }
            if (minInd!=-1) d[i] = d[minInd]+1; //
            else d[i] = 1;
        }

        Arrays.sort(d);
        System.out.println(d[N-1]);
    }
}