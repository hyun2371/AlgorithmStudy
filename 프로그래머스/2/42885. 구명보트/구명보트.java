import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        int lt = 0, rt = people.length-1;
        while (lt<=rt){
            if (people[lt]+people[rt]<=limit){
                lt++; rt--;
            }
            else {
                rt--;
            }
            cnt++;
        }
        
        
        return cnt;
    }
}