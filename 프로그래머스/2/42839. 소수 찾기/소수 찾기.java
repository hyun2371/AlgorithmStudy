import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    static int N;
    static String s,tmp = "";
    static boolean[] visited;
    
    public int solution(String numbers) {
        s = numbers;
        N = numbers.length();
        visited = new boolean[N];
        
        for (int len=1;len<=N;len++){//만들 숫자 길이
            DFS(0,len);
        }
        
        int cnt = 0;
        for (int x : set){
            if(isPrime(x)) cnt++;
        }
        return cnt;
    }
    
    private static void DFS(int lv, int len){
        if (lv==len){
            if (!tmp.equals(""))
                set.add(Integer.valueOf(tmp));
            return;
        }
        for (int i=0;i<N;i++){
            if (visited[i]) continue;
            visited[i] = true;
            tmp += s.charAt(i);
            DFS(lv+1,len);
            visited[i] = false;
            tmp = tmp.substring(0,tmp.length()-1);
        }
    }
    
    private static  boolean isPrime(int x){
        if (x<2) return false;
        for (int i=2;i<=Math.sqrt(x);i++){
            if (x%i==0) return false;
        }
        return true;
    }
}