import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        int cnt=0;
        char start = grid[0][0];
        for (int i=1;i<=R-3;i++){
            for (int j=1;j<=C-3;j++){
                if (grid[i][j]!=start){
                    for (int k=i+1;k<=R-2;k++){
                        for (int l=j+1;l<=C-2;l++){
                            if (grid[k][l]==start) cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}