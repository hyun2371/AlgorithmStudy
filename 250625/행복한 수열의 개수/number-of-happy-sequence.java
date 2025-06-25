import java.util.Scanner;
  
public class Main {
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] arr = new int[N][N];

        int answer = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for (int r=0;r<N;r++){
            if (isSerial(arr[r])) answer++;
        }
        
        int[] line = new int[N];
        for (int c=0;c<N;c++){
            for (int r =0;r<N;r++){
                line[r] = arr[r][c];
            }
            if (isSerial(line)) answer++;
        }
        
        System.out.println(answer);
    }

    private static boolean isSerial(int[] line){
        if (M==1) return true;
        int cnt = 1;
        for (int i=1;i<N;i++){
            if (line[i]==line[i-1]){
                cnt++;
                if (cnt>=M) return true;
            }
            else cnt = 1;
        }
        return false;
    }
}