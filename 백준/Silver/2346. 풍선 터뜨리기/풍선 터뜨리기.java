import java.io.*;
import java.util.*;

class Main {
    public int[] solution(int[] arr, int n) { 
        int[] answer = new int[n];
        Deque<int[]> deque = new ArrayDeque<>();
        
        for (int i=1;i<n;i++){
            deque.offer(new int[]{i+1,arr[i]});
        }
        
        int[] b = new int[2]; int ind = 1;
        int k = arr[0]; answer[0] = 1;
        while (!deque.isEmpty()){
            if (k>0) {
                for (int i=1;i<k;i++){
                    deque.addLast(deque.poll());
                }
                b = deque.poll();
                
            } else {
                 for (int i=1;i<-k;i++){
                     deque.addFirst(deque.pollLast());
                 }
                b = deque.pollLast();
                
            }
            k = b[1];
            answer[ind++] = b[0];
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main t = new Main();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : t.solution(arr,n)){
            bw.write(x+" ");
        }
        bw.flush();
    }
}