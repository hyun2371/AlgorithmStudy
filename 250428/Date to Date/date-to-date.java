import java.util.*;
import java.io.*;
public class Main {
    static int[] dpm = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int term = getElapsedDay(m2,d2)-getElapsedDay(m1,d1);
        System.out.println(term);
    }
    private static int getElapsedDay(int month, int day){
        int elapsedDay = 0;
        month--; // 해당 월은 day만 더하므로 포함 안됨
        while (month-->=1){
            elapsedDay += dpm[month];
        }
        return elapsedDay+day;
    }
}