import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] digits = new int[20];

        int ind = 0;
        while (true){
            if (n<b) {
                digits[ind] = n;
                break;
            }
            digits[ind++] = n%b;
            n/=b;
        }
        for (int i=ind;i>=0;i--){
            System.out.print(digits[i]);
        }
    }
}