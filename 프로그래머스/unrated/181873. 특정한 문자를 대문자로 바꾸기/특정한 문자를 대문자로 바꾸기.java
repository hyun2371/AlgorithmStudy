import java.util.*;
class Solution {
    public String solution(String my_string, String alp) {
        String k = alp.toUpperCase();
        return my_string.replaceAll(alp,k);
    }
}