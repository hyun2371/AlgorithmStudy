import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int k = num/5;
        int cnt =0;
       
        while (k>0){
            if ((num-5*k)%2==0) {
                num-=5*k;
                cnt = k;
                break;
            }
            k--;
        }
        
        cnt+=num/2;
        System.out.println(cnt);
    }
}