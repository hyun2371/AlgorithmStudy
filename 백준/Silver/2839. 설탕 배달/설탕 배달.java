import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer, cnt = 0;
        int n = sc.nextInt();
        while (true){
            if (n%5==0){
                answer=n/5+cnt;
                break;
            } else if (n<0){
                answer = -1;
                break;
            }
            n-=3;
            cnt++;
        }
        System.out.println(answer);
    }
}