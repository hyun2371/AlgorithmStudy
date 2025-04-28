import java.util.Scanner;

public class Main {
    private static int[] dpm = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String yoil = sc.next();

        int term = getElapsedTime(m2, d2)-getElapsedTime(m1, d1); // 날짜 차이
        term-=yoilDiff(yoil); //yoil로 이동함에 따라 term 차감
        System.out.println(term/7+1); // yoil로 이동했을 때 1번 더함
    }

    private static int getElapsedTime(int m, int d){
        int elapsedTime = 0;
        for (int i=1;i<m;i++){
            elapsedTime+=dpm[i];
        }
        elapsedTime+=d;
        return elapsedTime;
    }

    private static int yoilDiff(String yoil){
        if (yoil.equals("Mon")) return 0;
        if (yoil.equals("Tue")) return 1;
        if (yoil.equals("Wed")) return 2;
        if (yoil.equals("Thu")) return 3;
        if (yoil.equals("Fri")) return 4;
        if (yoil.equals("Sat")) return 5;
        else return 6;
    }
}