import java.util.Scanner;

public class Main {
    static int[] a = new int[1_000_001]; 
    static int[] b = new int[1_000_001];
    static int t,timeA = 1, timeB = 1;
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

        for (int i=0;i<m;i++){
            dir = sc.next().charAt(0);
            t = sc.nextInt();
            moveB(dir,t);
        }

        int time = -1;
        for (int i=1;i<Math.min(timeA, timeB);i++){
            if (a[i]==b[i]){
                time = i; break;
            }
        }
        System.out.println(time);
    }

    private static void moveA(char dir, int t){
        while (t-->0){
            if(dir=='R') 
                a[timeA] = a[timeA-1]+1;
            else 
                a[timeA] = a[timeA-1]-1;
            timeA++;
        }
    }

    private static void moveB(char dir, int t){
       while (t-->0){
            if(dir=='R') 
                b[timeB] = b[timeB-1]+1;
            else 
                b[timeB] = b[timeB-1]-1;
            timeB++;
        }
    }
}