import java.util.Scanner;
public class Main {
    static int[] dpm = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    

    public static void main(String[] args) {
        String[] yoil = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int term = getElapsedDay(m2,d2)-getElapsedDay(m1,d1);
        while (term<0) term+=7; // 요일 같음

        System.out.println(yoil[term%7]);
    }

    private static int getElapsedDay(int month, int day){
        int elapsedDay = 0;
        for (int i=1;i<month;i++){
            elapsedDay+=dpm[i];
        }
        elapsedDay+=day;
        return elapsedDay;
    }
}
