import java.io.*;
import java.util.*;

class Main {
    public int solution(int n) { 
       int answer = 0;
       Queue<Integer> que = new LinkedList<>();
        for (int i=1;i<=n;i++) que.offer(i);
        while (!que.isEmpty()){
            if (que.size()==1) answer = que.poll();
            else {
                que.poll();
                que.offer(que.poll());
            }
        }
       return answer;
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main t = new Main();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        System.out.println(t.solution(n));
    }
}