import java.util.*;

public class Main {
    static int[] cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int answer =0;
        for (int num=x;num<=y;num++){
            initCnt(num);
            if (isFunNum()) answer++;
            // System.out.println(num+" "+isFunNum());
        }
        System.out.println(answer);
    }

    private static void initCnt(int num){
        cnt = new int[10];
        while (num!=0){
            cnt[num%10]++;
            num/=10;
        }
    }

    private static boolean isFunNum(){
        int chance = 2;
        boolean isLocked = false;
        for (int v : cnt){
            if (v>0) {
                if (chance==0) return false;
                if (v>1&&isLocked) return false;
                if (v>1) isLocked = true;
                chance--;
            }
        }
        return chance==0;
    }
}