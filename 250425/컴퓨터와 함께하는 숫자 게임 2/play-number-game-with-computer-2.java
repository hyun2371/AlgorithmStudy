import java.util.Scanner;

public class Main {
    static long M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (long i=A;i<=B;i++){
            int tries = bs(i);
            min = Math.min(tries, min);
            max = Math.max(tries, max);
        }
        System.out.println(min+" "+max);
    }

    private static int bs(long target){
        int tries = 0;
        long lt =1, rt = M;
        while (lt<=rt){
            tries++;
            long mid = (lt+rt)/2;
            if (mid>target) rt = mid-1;
            else if (mid<target) lt = mid+1;
            else break;
        }
        return tries;
    }
}