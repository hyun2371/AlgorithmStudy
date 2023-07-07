import java.util.stream.*;
class Solution {
    public int solution(int n) {
        return (int)IntStream.rangeClosed(1,n)
            .filter(x->n%x==0).count();
    }
}