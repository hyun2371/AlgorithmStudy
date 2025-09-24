import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums= new int[]{1,2,5};
        int n = sc.nextInt();
        int[] d = new int[n+1];
        d[0] = 1;

        for (int i=1;i<=n;i++){
            for (int j=0;j<nums.length;j++){
                if (i>=nums[j]){
                    d[i] = (d[i]+d[i-nums[j]])%10_007;
                }
            }
        }
        System.out.println(d[n]);
    }
}