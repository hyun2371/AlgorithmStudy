import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for (int i=0;i<n;i++){
			int x = Integer.parseInt(br.readLine());
			pq.offer(x);
		}
		int total = 0;
		while (pq.size()>1){
			int a = pq.poll();
			int b = pq.poll();
			total+=(a+b);
			pq.offer(a+b);
		}
		System.out.println(total);
	}
}