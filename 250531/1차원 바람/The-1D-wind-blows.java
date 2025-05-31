import java.util.*;

public class Main {
    static int N,M;
    static int[][] a;
    static char dir;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int T = sc.nextInt();
        a = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                a[i][j] = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            int rowInd = sc.nextInt()-1;
            dir = sc.next().charAt(0);
            
            elect(rowInd);
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void elect(final int rowInd){
        move(a[rowInd]); //현재행 전파
        char tmpDir = dir;
        int curInd = rowInd-1;
        
        while (curInd>=0){ //1,0 현재행 위 전파
            if (equalRowExists(a[curInd],a[curInd+1]))
                move(a[curInd]);
            curInd--;
        }

        curInd = rowInd+1;
        dir = tmpDir;
        while (curInd<N){ //3,4,5 현재행 아래 전파
            if (equalRowExists(a[curInd],a[curInd-1]))
                move(a[curInd]);
            curInd++;
        }
    }

    private static boolean equalRowExists(int[] row1, int[] row2){
        for (int i=0;i<M;i++){
            if (row1[i]==row2[i]) return true;
        }
        return false;
    }

    private static void move(int[] row){ //전파 후 방향 전환
        if (dir=='L') {
            moveR(row);
            dir = 'R';
        }
        else {
            moveL(row);
            dir = 'L';
        }
        
    }

    private static void moveL(int[] row){
        int tmp = row[0];
        for (int i=0;i<M-1;i++){
            row[i] = row[i+1];
        }
        row[M-1] = tmp;
    }

    private static void moveR(int[] row){
        int tmp = row[M-1];
        for (int i=M-1;i>0;i--){
            row[i] = row[i-1];
        }
        row[0] = tmp;
    }
}