import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		while (N-- >0){
			long x = Integer.parseInt(st.nextToken());
			pq.offer(x);
		}

		while (M-- >0){
			long num1 = pq.poll();
			long num2 = pq.poll();
			pq.add(num1+num2);
			pq.add(num1+num2);
		}

		long total =0;
		while (!pq.isEmpty()){
			total+=pq.poll();
		}

		System.out.print(total);
	}
}