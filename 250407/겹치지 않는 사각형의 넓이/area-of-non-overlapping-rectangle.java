import java.util.*;
import java.io.*;
public class Main {
    private static final int OFFSET = 1_000;
    private static final int LENGTH = 2_000;
    private static boolean[][] area = new boolean[LENGTH+1][LENGTH+1];
    public static void main(String[] args) throws IOException{
        
        int[][] x = new int[3][2]; //직사각형 종류, 시작 끝
        int[][] y = new int[3][2];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i][0] = Integer.parseInt(st.nextToken())+OFFSET;
            y[i][0] = Integer.parseInt(st.nextToken())+OFFSET;
            x[i][1] = Integer.parseInt(st.nextToken())+OFFSET;
            y[i][1] = Integer.parseInt(st.nextToken())+OFFSET;

            boolean flag;
            if (i==2) flag = false;
            else flag = true;

            color(x[i][0],x[i][1],y[i][0],y[i][1],flag);
        }
        
        int cnt = 0;
        for (int i=0;i<=LENGTH;i++){
            for (int j=0;j<=LENGTH;j++){
                if (area[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }

    // 범위만큼 직사각형 c로 칠하기
    private static void color(int x1,int x2,int y1,int y2,boolean flag){
        for (int r = x1; r<x2; r++){
            for (int c = y1;c<y2;c++){
                area[r][c] = flag;
            }
        }
    }
}