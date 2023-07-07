class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] cArr = my_string.toCharArray();
        for (char c : cArr){
            if (Character.isUpperCase(c)){
                answer+=Character.toLowerCase(c);
            } else {
                answer+=Character.toUpperCase(c);
            }
        }
        return answer;
    }
}