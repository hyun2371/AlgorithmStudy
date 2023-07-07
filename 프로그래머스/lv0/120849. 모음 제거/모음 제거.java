class Solution {
    public String solution(String my_string) {
        char[] arr = {'a','e','i','o','u'};
        for (char c : arr){
            my_string = my_string.replace(String.valueOf(c),"");
        }
        return my_string;
        
    }
}