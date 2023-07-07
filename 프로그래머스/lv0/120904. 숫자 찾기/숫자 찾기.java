class Solution {
    public int solution(int num, int k) {
       String[] sArr = String.valueOf(num).split("");
       for (int i = 0 ;i<sArr.length;i++){
           if (Integer.parseInt(sArr[i]) ==k){
               return i+1;
           }
       }
        return -1;
    }
}