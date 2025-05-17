import java.util.*;
public class Main {
    static String s1, s2;
    static int l1, l2;
    static int[][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s1 = sc.next();
        s2 = sc.next();
        l1 = s1.length();
        l2 = s2.length();
        d = new int[l1][l2];

        initFirstRow();
        initFirstCol();
       
        for (int i=1;i<l1;i++){
            for (int j=1;j<l2;j++){
                if (s1.charAt(i)==s2.charAt(j)){
                    d[i][j] = d[i-1][j-1]+1;
                }
                else {
                    d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
                }
            }
        }

        int lcsLen = d[l1-1][l2-1];
        System.out.println((l1-lcsLen)+(l2-lcsLen));
    }

    private static void initFirstRow(){
        // 1행 초기화 
        // s1[0]==s2[i] => i부터 끝까지 d[0][i]=1로 초기화
        char key = s1.charAt(0);
        for (int i=0;i<l2;i++){
            if (key==s2.charAt(i)){
                for (int j=i;j<l2;j++){
                     d[0][j] = 1;
                }
                return;  
            }
            d[0][i] = 0;
        }
    }
    private static void initFirstCol(){
         // 1열 초기화
        char key = s2.charAt(0);
        for (int i=0;i<l1;i++){
            if (key==s1.charAt(i)){
                for (int j=i;j<l1;j++){
                     d[j][0] = 1;
                }
                return;
            }
            d[i][0] = 0;
        }
    }
}