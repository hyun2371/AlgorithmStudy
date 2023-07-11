class Solution {
    public int solution(String my_string, String is_suffix) {
        if (is_suffix.length()>my_string.length())
            return 0;
        String sub = my_string.substring(my_string.length()-is_suffix.length(),my_string.length());
        if (sub.equals(is_suffix)){
            return 1;
        }
        return 0;
    }
}