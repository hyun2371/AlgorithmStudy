import java.util.*;

public class Main {
    //북->동, 동->남, 남->서, 서->북
    private static int[] dx={0,1,0,-1}; //북동남서
    private static int[] dy ={1,0,-1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.
        int x = 0, y=0;
        int dir = 0;
        for (char cmd:s.toCharArray()){
            if (cmd=='L'){
                dir = (3-dir)%4;
            }else if (cmd=='R'){
                dir = (dir+1)%4;
            }else {
                x += dx[dir];
                y+=dy[dir];
            }
        }
        System.out.println(x+" "+y);
    }
}