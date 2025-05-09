import java.util.*;

public class Main {
    static int[] nums, targets;
    static int N,K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        K = sc.nextInt();  //추출

        nums = new int[N];
        targets = new int[K];
        for (int i=0;i<N;i++){
            nums[i] = i+1;
        }
        
        DFS(0);
    }

    private static void DFS(int lv){
        if (lv==K){
            for (int i=0;i<K;i++){
                System.out.print(targets[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i=0;i<N;i++){
            targets[lv]=i+1;
             DFS(lv+1);
        }
    }
}