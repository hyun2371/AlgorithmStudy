class Solution {
    public int solution(String my_string) {
        int answer =0;
        String tmp = "";
        char[] arr = my_string.toCharArray();
        for (char c : arr){
            if (Character.isDigit(c)){
                tmp+=(c+"");
            } else {
                if (!tmp.isEmpty())
                    answer+=Integer.parseInt(tmp);
               tmp = "";
            }
        }
        if (!tmp.isEmpty())
            answer+=Integer.parseInt(tmp);
        return answer;
    }
}