import java.util.*;
import java.io.*;
public class Main {
    private static final int OFFSET = 1000;
    private static final int LEN = 2001;
    public static void main(String[] args) throws IOException{
        int[][] start = new int[2][2];
        int[][] end = new int[2][2];
        boolean[][] area = new boolean[LEN][LEN];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0;i<2;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[i][0]= Integer.parseInt(st.nextToken())+OFFSET;
            start[i][1]=Integer.parseInt(st.nextToken())+OFFSET;
            end[i][0]=Integer.parseInt(st.nextToken())+OFFSET;
            end[i][1]=Integer.parseInt(st.nextToken())+OFFSET;
            
            for (int r=start[i][0];r<end[i][0];r++){
                for (int c=start[i][1];c<end[i][1];c++){
                    if (i==0) area[r][c]=true;
                    else area[r][c] = false;
                }
            }
        }

        boolean isFirstExists = false;
        int minX=Integer.MAX_VALUE,maxX=Integer.MIN_VALUE,minY=Integer.MAX_VALUE,maxY=Integer.MIN_VALUE;
        for (int r=0;r<LEN;r++){
            for (int c=0;c<LEN;c++){
                if (area[r][c]){
                    isFirstExists = true;
                    minX = Math.min(r,minX);
                    minY= Math.min(c,minY);
                    maxX = Math.max(r,maxX);
                    maxY = Math.max(c,maxY);
                }
            }
        }

        int answer = 0;
        if (isFirstExists) answer =(maxX-minX+1)*(maxY-minY+1);
        else answer = 0;
        System.out.println(answer);
    }
}