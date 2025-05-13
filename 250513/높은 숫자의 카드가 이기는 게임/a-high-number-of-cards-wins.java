import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> bSet = new HashSet<>();

        int n = sc.nextInt();
        int[] aCards = new int[n];
        int[] bCards = new int[n];

        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
        }
        //b 포함여부 판단 위해 set으로 넣기
        for (int i = 0;i<n;i++){
            bSet.add(bCards[i]);
        }
        
        //a초기화
        int aIndex = 0;
        for (int i=1;i<=2*n;i++){
            if (!bSet.contains(i)){
                aCards[aIndex++] = i;
            }
        }

        Arrays.sort(aCards);
        Arrays.sort(bCards);

        //a요소가 b요소보다 클 경우 b한칸 옮기고 cnt증가
        int bIndex = 0, cnt = 0;
        for (int i=0;i<n;i++){
            if (aCards[i]>bCards[bIndex]){
                bIndex++;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}