class Solution {
    public int solution(int[] num_list) {
        String str_n1="", str_n2="";
        for (int n : num_list){
            if (n%2!=0){
                str_n1 += n+"";
            } else {
                str_n2 += n+"";
            }
        }
        return Integer.parseInt(str_n1)+Integer.parseInt(str_n2);
        
    }
}