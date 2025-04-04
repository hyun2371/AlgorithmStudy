import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        
        int target = binToten(binary)*17;
        tenTobin(target);
    }

    private static int binToten(String binary){
        char[] arr = binary.toCharArray();
        int num =0 ;
        for (int i=0;i<arr.length;i++){
            num = num*2 + arr[i]-'0';
        }
        return num;
    }

    private static void tenTobin(int target){
        int ind = 0;
        int[] digits = new int[20];
        while (true){
            if (target<2) {
                digits[ind] = target; break;
            }
            digits[ind++] = target%2;
            target/=2;
        }
        for (int i=ind;i>=0;i--){
            System.out.print(digits[i]);
        }
    }
}