import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int n) {
        int a = IntStream.rangeClosed(0,n).filter(x->x%2==0).sum();
        return a;
    }
}