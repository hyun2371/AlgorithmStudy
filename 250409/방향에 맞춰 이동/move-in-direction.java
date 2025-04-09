import java.util.*;
public class Main {
    
   
    public static void main(String[] args) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 0;
        
        for (int i = 0; i < n; i++) {
            char dir = sc.next().charAt(0);
            int dis= sc.nextInt();
            int ind = 0;
            if (dir=='S') ind = 0;
            else if (dir=='N') ind = 1;
            else if (dir=='W') ind = 2;
            else ind = 3;


            x+=dx[ind]*dis;
            y+=dy[ind]*dis;

        }

        System.out.println(y+" "+x);
    }
}