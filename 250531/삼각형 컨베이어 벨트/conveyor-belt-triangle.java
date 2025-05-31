import java.util.Scanner;
public class Main {
    private static int N;
    private static int[] top,mid, bottom;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        top = new int[N];
        mid = new int[N];
        bottom = new int[N];
        
        for (int i = 0; i < N; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            mid[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            bottom[i] = sc.nextInt();
        }
        
        while (T-->0){
            move();
        }
        
        print(top);
        print(mid);
        print(bottom);
    }

    private static void move(){
        int tmp = bottom[N-1];


        for (int i=N-1;i>0;i--){
            bottom[i] = bottom[i-1];
        }

        bottom[0] = mid[N-1];

        for (int i=N-1;i>0;i--){
            mid[i] = mid[i-1];
        }
        mid[0] = top[N-1];

        for (int i=N-1;i>0;i--){
            top[i] = top[i-1];
        }
        top[0] = tmp;
    }

    private static void print(int[] arr){
        for (int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}