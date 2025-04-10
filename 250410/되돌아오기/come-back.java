import java.util.Scanner;
public class Main {
    private static int[] dx = {-1,0,0,1};
    private static int[] dy = {0,1,-1,0};
    private static int totalSec=0,x=0,y=0,ans=-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dis = sc.nextInt();
            int dirNum = getDirNum(dir);

            boolean isDone = move(dis,dirNum);
            if (isDone) break;
        }
        System.out.println(ans);
    }

    private static int getDirNum(char dir){
        if (dir=='N') return 0;
        if (dir=='E') return 1;
        if (dir=='W') return 2;
        else return 3;
    }

    private static boolean move(int dis, int dirNum){
        while (dis-->0){
            x+=dx[dirNum];
            y+=dy[dirNum];

            totalSec++;
            if (x==0&&y==0) {
                ans = totalSec;
                return true;
            }
        }
        return false;
    }
}