import java.io.*;
import java.util.*;

class Main {
    public int[] solution(int n, int k) { 
       int[] answer= new int[n];
        Queue<Integer> que = new LinkedList<>();
        for (int i=1;i<=n;i++) que.offer(i);

        for (int i=0;i<n;i++){
            for (int j=0;j<k-1;j++)
                que.offer(que.poll());
            answer[i] = que.poll();
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new
        OutputStreamWriter(System.out));
        Main t = new Main();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bw.write("<");
        int[] answer = t.solution(n,k);
        for (int i=0;i<n;i++){
            if (i==n-1) bw.write(answer[i]+">");
            else bw.write(answer[i]+", ");
        }
        bw.flush();
        br.close();
    }
}