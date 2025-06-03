import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int N = A.length();
        int M = B.length();
        int[][] d = new int[N][M]; //i번째까지 문자열과 j번째까지 문자열로 만들 수 있는 lcs 길이
        //0행 초기화
        int value = 0;
        for (int i=0;i<M;i++){
            if (A.charAt(0)==B.charAt(i)){
                value = 1;
            }
            d[0][i] = value;
        }
        //0열 초기화
        value = 0;
        for (int i=0;i<N;i++){
            if (A.charAt(i)==B.charAt(0)){
                value = 1;
            }
            d[i][0] = value;
        }

        for (int i=1;i<N;i++){
            for (int j=1;j<M;j++){
                if (A.charAt(i)==B.charAt(j)){
                    d[i][j]=d[i-1][j-1]+1;
                } else {
                    d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
                }
            }
        }
        System.out.println(d[N-1][M-1]);
    }
}