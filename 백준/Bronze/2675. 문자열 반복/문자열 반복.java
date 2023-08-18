import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            int cnt = sc.nextInt();
            String str = sc.next();
            for (int j =0;j<str.length();j++)
                System.out.print(str.substring(j,j+1).repeat(cnt));
            System.out.println();
        }
    }
}