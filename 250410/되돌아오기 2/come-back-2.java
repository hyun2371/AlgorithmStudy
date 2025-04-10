import java.util.Scanner;
public class Main {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int x=0,y=0,dirNum=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        
        int ans = -1;
        int totalTime =0;
        for (char cmd : command.toCharArray()){
            totalTime++;
            if (cmd=='R'){
                dirNum = (dirNum+1)%4;
            } else if (cmd=='L'){
                dirNum = 3-dirNum;
            } else {
                x+=dx[dirNum];
                y+=dy[dirNum];
               if (x==0&&y==0){
                  ans = totalTime; break;
               }
            }
        }
        System.out.println(ans);
    }


}