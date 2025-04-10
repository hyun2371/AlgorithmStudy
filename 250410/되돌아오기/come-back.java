import java.util.Scanner;
public class Main {
    private static int[] dx = {-1,0,0,1};
    private static int[] dy = {0,1,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y=0;
        int totalSec=1;
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dis = sc.nextInt();
            int dirNum = getDirNum(dir);

            for (int j=1;j<=dis;j++,totalSec++){
                x+=dx[dirNum];
                y+=dy[dirNum];
                if (x==0&&y==0){ //시작점 도착
                    System.out.println(totalSec);
                    System.exit(0);
                }
            }
        }
        System.out.println(-1);
        
    }

    private static int getDirNum(char dir){
        if (dir=='N') return 0;
        if (dir=='E') return 1;
        if (dir=='W') return 2;
        else return 3;
    }
}