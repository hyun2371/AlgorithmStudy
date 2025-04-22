import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("size")) {
                System.out.println(pq.size());
            }
            if (cmd.equals("empty")){
                System.out.println(pq.isEmpty()?1:0);
            }
            if (cmd.equals("pop")){
                System.out.println(pq.poll());
            }
            if (cmd.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                pq.add(x);
            }
            if (cmd.equals("top")){
                System.out.println(pq.peek());
            }
        }
        
        
    }
}