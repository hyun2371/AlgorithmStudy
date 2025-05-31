import java.util.*;
public class Main {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static int N;
    private static int[] top,bottom;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        top = new int[N];
        bottom = new int[N];

        for (int i=0;i<N;i++){
            top[i] = sc.nextInt();
        }
        for (int i=0;i<N;i++){
            bottom[i] = sc.nextInt();
        }
        
        while (T-->0){
            move();
        }
        for (int i=0;i<N;i++){
            System.out.print(top[i]+" ");
        }
        System.out.println();
        for (int i=0;i<N;i++){
            System.out.print(bottom[i]+" ");
        }
    }

    private static void move(){
        int tmp = top[N-1];
        for (int i=N-1;i>0;i--){
            top[i] = top[i-1];
        }
        top[0] = bottom[N-1];

        for (int i=N-1;i>0;i--){
            bottom[i] = bottom[i-1];
        }
        bottom[0] = tmp;
    }
}