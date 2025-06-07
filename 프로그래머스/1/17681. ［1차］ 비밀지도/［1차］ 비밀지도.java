class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            String s = Integer.toBinaryString(arr1[i]|arr2[i]);
            while (s.length()!=n) s="0"+s;

            for (int j=0;j<s.length();j++){
                String tmp = s.charAt(j)=='1'?"#":" ";
                sb.append(tmp);
            }
            answer[i] = sb.toString();      
        }
        
        return answer;
    }
}