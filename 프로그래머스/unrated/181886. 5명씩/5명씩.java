class Solution {
    public String[] solution(String[] names) {
        int ans_len = names.length%5==0?names.length/5:names.length/5+1;
        if (names.length<5)
            ans_len = 1;
        String[] ans = new String[ans_len];
        int ind = 0;
        for (int i = 0;i<names.length;i+=5){
            ans[ind++]=names[i];
        }
    
        return ans;
    }
}