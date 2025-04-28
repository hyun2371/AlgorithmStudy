import java.util.Scanner;

public class Main {
    private static int[] dpm = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();

        int startDay = getElapsedDays(m1,d1);
        int endDay = getElapsedDays(m2,d2);
        int curYoil = getYoil(A);
        
        int answer = 0;
        for (int d = startDay;d<=endDay;d++){
            if (curYoil==getYoil(A)) answer++;
            curYoil = (curYoil+1)%7;
        }
        System.out.println(answer); // yoil로 이동했을 때 1번 더함
    }

    private static int getElapsedDays(int m, int d){
        int elapsedDays = 0;
        for (int i=1;i<m;i++){
            elapsedDays+=dpm[i];
        }
        elapsedDays+=d;
        return elapsedDays;
    }

    private static int getYoil(String yoil){
        if (yoil.equals("Mon")) return 0;
        if (yoil.equals("Tue")) return 1;
        if (yoil.equals("Wed")) return 2;
        if (yoil.equals("Thu")) return 3;
        if (yoil.equals("Fri")) return 4;
        if (yoil.equals("Sat")) return 5;
        return 6;
    }
}