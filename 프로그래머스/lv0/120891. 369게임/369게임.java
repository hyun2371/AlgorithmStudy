class Solution {
    public int solution(int order) {
        String s_order = String.valueOf(order);
        int answer = 0;
        for (int i =0 ;i<s_order.length();i++){
            char c = s_order.charAt(i);
            if (c=='3'||c=='6'||c=='9'){
                answer+=1;
            }
        }
        return answer;
    }
}