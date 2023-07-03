class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] chars = my_string.toCharArray();
        for (Character c : chars) {
            if (Character.isLowerCase(c)) {
                answer += Character.toUpperCase(c);
            } else {
                answer += Character.toLowerCase(c);
            }

        }
        return answer;
    }
}