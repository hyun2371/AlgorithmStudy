import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int x =0 , y=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char dir = sc.next().charAt(0);
            int dis = sc.nextInt();
            int ind;

            if (dir=='N') ind = 0;
            else if (dir=='E') ind = 1;
            else if (dir=='S')ind = 2;
            else ind = 3;

            x+=dx[ind]*dis;
            y+=dy[ind]*dis;
        }
        System.out.println(x+" "+y);
    }
}