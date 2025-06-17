import java.util.Scanner;

public class Main {
    static int[] cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int answer =0;
        for (int num=x;num<=y;num++){
            initCnt(num);
            if (getDiffCnt()==1) answer++;
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

    private static int getDiffCnt(){
        int diffCnt = -1;
        for (int v : cnt){
            if (v>0) diffCnt++;
        }
        return diffCnt;
    }
}