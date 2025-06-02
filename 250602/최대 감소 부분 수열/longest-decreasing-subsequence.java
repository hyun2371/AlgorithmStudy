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

        for (int i=0;i<N;i++){
            d[i] = 1; //기본값
            for (int j=0;j<i;j++){
                if (arr[j]>arr[i]){//현재 값보다 큰 값이 앞에 있으면
                    d[i] = Math.max(d[i],d[j]+1); //이전값 카운트+1값 대입
                }
            }
        }

        Arrays.sort(d);
        System.out.println(d[N-1]);
    }
}