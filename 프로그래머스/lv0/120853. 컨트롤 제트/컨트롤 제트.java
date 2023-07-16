class Solution {
    public int solution(String s) {
        int answer = 0;
        String tmp = "";
        String[] arr = s.split(" ");
        
        for (int i =0;i<arr.length;i++){
            
            if (arr[i].equals("Z"))
                answer-=Integer.parseInt(tmp);
            else 
                answer+=Integer.parseInt(arr[i]);
            tmp = arr[i];
        }
        return answer;
    }
}