import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int offset = 100;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt()+offset;
            y1[i] = sc.nextInt()+offset;
            x2[i] = sc.nextInt()+offset;
            y2[i] = sc.nextInt()+offset;
        }
       
        int[][] area = new int[201][201];
        for (int k=0;k<2;k++){
            for (int i=x1[k];i<x2[k];i++){
                for (int j=y1[k];j<y2[k];j++){
                    area[i][j] = 1;
                }
            }
        }
        
        int answer = 0;
        for (int i=0;i<=200;i++){
            for (int j=0;j<=200;j++){
                if (area[i][j]==1) answer++;
            }
        }
        System.out.println(answer);
    }
}