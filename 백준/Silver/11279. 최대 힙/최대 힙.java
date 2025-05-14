import java.util.*;
import java.io.*;

public class Main {
	static Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		for (int i=0;i<n;i++){
			int x = Integer.parseInt(br.readLine());
			maxHeap(x);
		}
		System.out.println(sb.toString());
	}

	private static void maxHeap(int x){
		if (x==0){
			if (pq.isEmpty()) sb.append(0);
			else sb.append(pq.poll());
			sb.append("\n");
		}
		else pq.offer(x);
	}
}