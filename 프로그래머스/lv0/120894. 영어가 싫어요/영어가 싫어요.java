class Solution {
    public long solution(String numbers) {
        String answer="";
        int ind = 0;
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        while (ind<numbers.length()){
            numbers = numbers.substring(ind,numbers.length());
         
            for (int i =0;i<nums.length;i++){
                if (numbers.startsWith(nums[i])){
                    answer+=i+"";
                    ind=nums[i].length();
                    break;
                }
            }
        }  
        return Long.parseLong(answer);   
    }
}