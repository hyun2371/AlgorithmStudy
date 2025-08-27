import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        
        int ind = 0, cnt =0;
        while (ind<len){
            if (a.charAt(ind)!=b.charAt(ind)){
                cnt++;
                while (a.charAt(ind)!=b.charAt(ind)) {
                    ind++;
                }
            } 
            else ind++;
        }
        System.out.println(cnt);
    }
}