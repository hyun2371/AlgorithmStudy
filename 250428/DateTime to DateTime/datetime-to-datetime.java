import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int totalMin = getElapsedMin(A,B,C)-getElapsedMin(11,11,11);
        if (totalMin<0) System.out.println(-1);
        else System.out.println(totalMin);
    }

    private static int getElapsedMin(int d, int h, int m){
        return d*24*60+h*60+m;
    }
}