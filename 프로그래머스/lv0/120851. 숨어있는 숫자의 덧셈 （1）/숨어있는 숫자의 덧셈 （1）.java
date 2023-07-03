class Solution {
public int solution(String my_string) {
        int answer = 0;
        char[] chars = my_string.toCharArray();
        for (Character c : chars) {
            if (c>='0' && c<='9'){
                answer+=c-'0';
            }
        }
        return answer;
    }
}