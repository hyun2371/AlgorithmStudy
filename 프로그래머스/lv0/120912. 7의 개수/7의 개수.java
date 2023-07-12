class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for (int n : array){
            String n_str = String.valueOf(n);
            for (int i = 0;i<n_str.length();i++){
                if (n_str.charAt(i)=='7')
                    answer++;
            }
        }
        return answer;
    }
}