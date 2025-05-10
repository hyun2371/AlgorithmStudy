import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int indA = 1, indB = 1;
        int[] disA = new int[1001]; //시간별 거리
        int[] disB = new int[1001]; 

        for (int i = 0; i < N; i++) {
            int v = sc.nextInt(); //속도
            int t = sc.nextInt(); //시간
            
            while (t-->0){
                disA[indA] = disA[indA-1]+v;
                indA++;
            }
        }
        for (int i = 0; i < M; i++) {
            int v = sc.nextInt(); //속도
            int t = sc.nextInt(); //시간
            while (t-->0){
                disB[indB] = disB[indB-1]+v;
                indB++;
            }
        }

        int comb = 0;
        char status = ' ';
        for (int i=1;i<=14;i++){
            if (disA[i]==disB[i]&&status!='C'){
                comb++;
                status = 'C';
            }
            else if (disA[i]>disB[i]&&status!='A'){
                comb++;
                status = 'A';
            }
            else if (disA[i]<disB[i]&&status!='B'){
                comb++;
                status = 'B';
            }
        }
        System.out.print(comb);
    }
}