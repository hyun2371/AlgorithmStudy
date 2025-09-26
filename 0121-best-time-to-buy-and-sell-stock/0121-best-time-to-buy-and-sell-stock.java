class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int minPrice = prices[0];
        for (int i=1;i<prices.length;i++){
            int profit = prices[i]-minPrice;
            answer = Math.max(answer,profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return answer;
    }
}