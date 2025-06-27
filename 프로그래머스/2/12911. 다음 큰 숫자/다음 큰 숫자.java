class Solution {
    public int solution(int n) {
        String binStr = toBinStr(n);
        int cnt = getOneCnt(binStr);

        for (int i=n+1;;i++){
            if (cnt==getOneCnt(toBinStr(i)))
                return i;
        }
    }
    
    private static String toBinStr(int n){
        StringBuilder sb = new StringBuilder();
        
        while (n!=0){
            sb.append(n%2);
            n/=2;
        }
        
        return sb.reverse().toString();
    }
    

    private static int getOneCnt(String binStr){
        int cnt = 0;
        for (char c : binStr.toCharArray()){
            if (c=='1') cnt++;
        }
        return cnt;
    }
}