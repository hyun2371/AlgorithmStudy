import java.util.Scanner;
public class Main {
    private static final int OFFSET = 100_000;
    private static final int LENGHT = 200_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //각 명령
        int[] start = new int[n]; // 시작좌표
        int[] end = new int[n]; // 끝 좌표
        char[] color = new char[n]; //색깔

        char[] area = new char[LENGHT+1]; //색깔 타일 

        int cur=0; // 현재 위치
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if (d=='L'){
                color[i] = 'W';
                start[i] = cur-x;
                end[i] = cur;
                cur-=x;
            }
            else {
                color[i] = 'B';
                start[i] = cur;
                end[i] = cur+x;
                cur += x;
            }
            start[i]+=OFFSET;
            end[i]+=OFFSET;
        }

        for (int i=0;i<n;i++){
            for (int ind = start[i];ind<end[i];ind++){
                area[ind] = color[i];
            }
        }

        // 타일 개수 구하기
        int b_cnt = 0, w_cnt=0;
        for (int i=0;i<=LENGHT;i++){
            if (area[i]=='W') w_cnt++;
            else if (area[i]=='B') b_cnt++;
        }
        System.out.println(w_cnt+" "+b_cnt);
    }
}