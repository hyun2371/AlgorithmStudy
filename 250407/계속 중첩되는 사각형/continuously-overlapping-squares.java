import java.util.Scanner;
public class Main {
    private static final int OFFSET = 100;
    private static final int LEN = 201;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] area = new char[LEN][LEN];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt()+OFFSET;
            int y1 = sc.nextInt()+OFFSET;
            int x2 = sc.nextInt()+OFFSET;
            int y2 = sc.nextInt()+OFFSET;

            for (int r=x1;r<x2;r++){
                for (int c=y1;c<y2;c++){
                    if (i%2==0)area[r][c] = 'r';
                    else area[r][c] = 'b';
                }
            }
            
        }
        
        int cnt = 0;
        for (int r=0;r<LEN;r++){
            for (int c=0;c<LEN;c++){
                if (area[r][c]=='b') cnt++;
            }
        }
        System.out.println(cnt);
    }
}