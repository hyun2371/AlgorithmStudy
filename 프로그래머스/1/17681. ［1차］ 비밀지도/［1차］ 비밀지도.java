class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            String s1 = toBinaryString(arr1[i],n); //01001
            String s2 = toBinaryString(arr2[i],n); //11110
            for (int j=0;j<n;j++){
                int b1 = s1.charAt(j)-'0';
                int b2 = s2.charAt(j)-'0';
                int result = b1|b2;
                String tmp = result==1?"#":" ";
                sb.append(tmp);
            }
            answer[i] = sb.toString();      
        }
        
        return answer;
    }
    
    private static String toBinaryString(int num, int n){
        String s = Integer.toBinaryString(num);
        while (s.length()!=n){
            s = "0"+s;
        }
        return s;
    }
}