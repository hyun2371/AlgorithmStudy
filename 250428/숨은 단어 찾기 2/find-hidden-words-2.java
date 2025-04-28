import java.util.Scanner;
public class Main {
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j=0;j<m;j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        for (int r=0;r<n;r++){
            for (int c = 0; c<m;c++){
                if (isPlusRange(r,n)){
                    if (isLee(arr[r][c],arr[r+1][c],arr[r+2][c])) cnt++;
                }
                if (isPlusRange(c,m)){
                    if (isLee(arr[r][c],arr[r][c+1],arr[r][c+2])) cnt++;
                }
                if (isMinusRange(r)){
                    if (isLee(arr[r][c],arr[r-1][c],arr[r-2][c])) cnt++;
                }
                if (isMinusRange(c)){
                    if (isLee(arr[r][c],arr[r][c-1],arr[r][c-2])) cnt++;
                }

                if (isPlusRange(r,n)&&isPlusRange(c,m)){
                    if (isLee(arr[r][c],arr[r+1][c+1],arr[r+2][c+2])) cnt++;
                }
                if (isPlusRange(r,n)&&isMinusRange(c)){
                    if (isLee(arr[r][c],arr[r+1][c-1],arr[r+2][c-2])) cnt++;
                }
                if (isMinusRange(r)&&isPlusRange(c,m)){
                    if (isLee(arr[r][c],arr[r-1][c+1],arr[r-2][c+2])) cnt++;
                }
                if (isMinusRange(r)&&isMinusRange(c)){
                    if (isLee(arr[r][c],arr[r-1][c-1],arr[r-2][c-2])) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean isPlusRange(int x, int size){
        return x<=size-3;
    }

    private static boolean isMinusRange(int x){
        return x>=2;
    }

    private static boolean isLee(char c1, char c2, char c3){
        return c1=='L'&&c2=='E'&&c3=='E';
    }
}