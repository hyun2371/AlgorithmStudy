import java.util.*;
class Solution {
    public int solution(String my_string) {
        int answer =0;
        String[] arr= my_string.replaceAll("[a-zA-z]"," ").split(" ");
        System.out.println(Arrays.toString(arr));
        for (String s : arr){
            if (!s.equals("")){//숫자 사이 연속해서 문자인 경우 빈값 들어감
                answer+=Integer.parseInt(s);
            }
        }
        return answer;
    }
}