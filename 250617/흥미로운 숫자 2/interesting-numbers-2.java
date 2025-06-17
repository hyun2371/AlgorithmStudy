import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int answer =0;
        for (int num=x;num<=y;num++){
            if (isFunNum(num)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean isFunNum(int num){
        int len = 0;
        int[] cnt = new int[10];
        while (num!=0){
            cnt[num%10]++;
            num/=10;
            len++;
        }

        for (int i=0;i<10;i++){
            if (cnt[i]==len-1) return true;
        }
        return false;
    }
}