import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();

        int cnt = 0;
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
               if( arr[i]=='('&&arr[j]==')')
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}