import java.util.*;

class Solution {
    static boolean[] vis;
    static Set<Integer> set;
    
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        vis = new boolean[numbers.length()];
        DFS(numbers,"",0);
        for (Integer x : set){
            if (isPrime(x)) answer++;
        }
        return answer;
    }
    
    private static void DFS(String numbers, String s,int lv){
        if (lv==numbers.length()) return;
        
        for (int i=0;i<numbers.length();i++){
            if (vis[i]) continue;
            vis[i] = true;
            set.add(Integer.parseInt(s+numbers.charAt(i)));
            DFS(numbers, s+numbers.charAt(i),lv+1);
            vis[i] = false;
        }
    }
    
    private static boolean isPrime(int N){
        if (N<2) return false;
        for (int i=2;i<=Math.sqrt(N);i++){
            if (N%i==0) return false;
        }
        return true;
    }
}