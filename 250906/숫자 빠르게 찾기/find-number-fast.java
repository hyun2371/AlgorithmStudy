import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
           System.out.println(getPos(arr,x));
        }
    }

    private static int getPos(int[] arr, int key){
        int lt = 0,rt = arr.length-1;
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if (arr[mid]<key){
                lt = mid+1;
            } else if (arr[mid]>key){
                rt = mid-1;
            }
            else {
                return mid+1;
            }
        }
        return -1;
        
    }
}