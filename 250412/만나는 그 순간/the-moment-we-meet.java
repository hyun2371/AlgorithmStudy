import java.util.Scanner;

public class Main {
    static int[] a = new int[1_000_001]; 
    static int[] b = new int[1_000_001];
    static int t,aInd = 0, bInd = 0,pos;
    static char dir;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n번
        int m = sc.nextInt();
    
        for (int i=0;i<n;i++){
            dir = sc.next().charAt(0);
            t = sc.nextInt();
            moveA(dir,t);
        }
        pos=0;
        for (int i=0;i<m;i++){
            dir = sc.next().charAt(0);
            t = sc.nextInt();
            moveB(dir,t);
        }

        int time = -1;
        for (int i=1;i<=Math.max(aInd, bInd);i++){
            if (a[i]==b[i]){
                time = i; break;
            }
        }
        System.out.println(time);
    }

    private static void moveA(char dir, int t){
        while (t-->0){
            if(dir=='R') pos++;
            else pos--;
            a[++aInd] = pos;
        }
    }

    private static void moveB(char dir, int t){
       while (t-->0){
            if(dir=='R') pos++;
            else pos--;
            b[++bInd] = pos;
        }
    }
}