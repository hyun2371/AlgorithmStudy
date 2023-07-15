class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] arr = my_string.toCharArray();
        for (char c : arr){
            if (Character.isLowerCase(c))
               answer[c-97+26]++;
            else
                answer[c-65]++;
        }
        return answer;
    }
}