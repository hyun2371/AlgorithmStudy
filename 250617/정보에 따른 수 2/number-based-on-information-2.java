import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] sPos = new int[100];
        int[] nPos = new int[100];
        int sInd = 0, nInd = 0;

        for (int i = 0; i < T; i++) {

            char c = sc.next().charAt(0);
            int pos = sc.nextInt();
            if (c=='S'){
                sPos[sInd++] = pos;
            } else {
                nPos[nInd++] = pos;
            }
        }
        
        int cnt = 0;
       for (int k=a;k<=b;k++){
            int minDisS = Integer.MAX_VALUE;
            int minDisN = Integer.MAX_VALUE;

            for (int i=0;i<sInd;i++){
                minDisS = Math.min(minDisS,Math.abs(sPos[i]-k));
            }

            for (int i=0;i<nInd;i++){
                minDisN = Math.min(minDisN,Math.abs(nPos[i]-k));
            }
            if (minDisS<=minDisN) cnt++;
       }
       System.out.println(cnt);
    }
}