class Solution {
    public int[] solution(int brown, int yellow) {
        int n = brown+yellow;
        for (int h=(int)Math.sqrt(n);h>=0;h--){
            if (n%h!=0) continue;
            int w = n/h;
            if (yellow==(w-2)*(h-2)) {
                return new int[]{w,h};
            }
        }
        return null;
    }
}