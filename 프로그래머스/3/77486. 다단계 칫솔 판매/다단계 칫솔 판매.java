import java.util.*;
class Solution {
    static int N;
    static Map<String, Integer> map = new HashMap<>();
    static int[] parentIdxs,totalProfits;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        parentIdxs = new int[N];
        totalProfits = new int[N];
        
        for (int i=0;i<N;i++){
            map.put(enroll[i],i);
        }
        map.put("-",-1);
        
        for (int i=0;i<referral.length;i++){
            parentIdxs[i] = map.get(referral[i]);
        }
        
        for (int i=0;i<seller.length;i++){
            int sellerIdx = map.get(seller[i]);
            calculate(sellerIdx,100*amount[i]);
        }

        return totalProfits;
    }
    
    private static void calculate(int sellerIdx, int profit){
        int curIdx = sellerIdx;
        int curProfit = profit;
        while (curIdx!=-1&&curProfit>0){
            int comission = curProfit/10;
            totalProfits[curIdx]+=curProfit-comission;
            
            curProfit = comission;
            curIdx = parentIdxs[curIdx];
        }
    }
}