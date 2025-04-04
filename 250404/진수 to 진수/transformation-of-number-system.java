import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();

        tenToB(B,aToTen(A,N));
    }

    private static int aToTen(int A, String N){
        int num = 0;
        for (int i=0;i<N.length();i++){
            num = num*A+N.charAt(i)-'0';
        }
        return num;
    }

    private static void tenToB(int B, int num){
        int ind = 0;
        int[] digits = new int[20];
        while (true){
            if (num<B) {
                digits[ind] = num; break;
            }
            digits[ind++] = num%B;
            num/=B;
        }
        for (int i=ind;i>=0;i--){
            System.out.print(digits[i]);
        }
    }
}