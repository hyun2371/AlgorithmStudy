import java.util.*;
public class Main {
    static int A,B,C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        int cnt =0;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                for (int k=1;k<=n;k++){
                    if (isOpen(i,j,k)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean isOpen(int f, int s, int t){
        return Math.abs(A-f)<=2||Math.abs(B-s)<=2||Math.abs(C-t)<=2;
    }
}