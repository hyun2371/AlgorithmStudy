import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }


        int cnt = 0;
        for (int i=0;i<N;i++){ //시작
            for (int j=i;j<N;j++){//끝
                int sum = 0;
                for (int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                double avg = sum*1.0/(j-i+1);
                boolean exist = false;
                for (int k=i;k<=j;k++){
                    if (arr[k]==avg) exist = true;
                }
                if (exist) cnt++;
            }
        }

        System.out.println(cnt);
    }
}