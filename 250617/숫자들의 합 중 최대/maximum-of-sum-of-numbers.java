import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int answer = 0;
        for (int i=x;i<=y;i++){
            answer = Math.max(answer, getSum(i));
        }
        System.out.println(answer);
    }

    private static int getSum(int n){
        int sum = 0;
        while (n!=0){
            sum += n%10;
            n/=10;
        }
        return sum;
    }
}