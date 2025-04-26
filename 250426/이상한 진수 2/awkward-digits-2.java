import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] arr = a.toCharArray();
        for (int i=0;i<arr.length;i++){
            if (arr[i]=='0') {
                arr[i]='1'; break;
            }
        }
        
        int total=0;
        for (int i=arr.length-1,mult=0;i>=0;i--,mult++){
            total+=(arr[i]-'0')*Math.pow(2,mult);
        }
        System.out.println(total);
    }
}