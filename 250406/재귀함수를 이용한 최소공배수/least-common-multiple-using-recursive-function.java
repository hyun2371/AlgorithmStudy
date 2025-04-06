import java.util.Scanner;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(dfs(0));
    }

    private static int dfs(int lv){
        if (lv==n) return 1;
        return arr[lv]*dfs(lv+1)/getGcd(arr[lv],dfs(lv+1));
    }

    private static int getGcd(int n, int m){
        int a = Math.max(n,m);
        int b = Math.min(n,m);
        if (a%b==0) return b;
        return getGcd(b,a%b);
    }
}