import java.util.Scanner;
public class Main {
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int maxCnt = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i+2>=n||j+2>=n) continue;
                int cnt = getCnt(i,i+2,j,j+2);
                maxCnt = Math.max(cnt,maxCnt);
            }
        }
        System.out.println(maxCnt);
    }

    private static int getCnt(int rowS, int rowE, int colS, int colE){
        int cnt = 0;
        for (int i=rowS;i<=rowE;i++){
            for (int j = colS;j<=colE;j++){
                if (arr[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
}