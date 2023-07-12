class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int ind = i; ind<=j;ind++){
            for (String s : String.valueOf(ind).split("")){
                if (s.equals(k+""))
                    answer++;
            }
         
        }
        return answer;
    }
}