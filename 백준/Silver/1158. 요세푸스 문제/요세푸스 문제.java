import java.util.*;
import java.io.*;

public class Main {
	private static List<Integer> lst = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		solution(N,K);
		for (int i=0;i<lst.size();i++){
			if (lst.size()==1)
				System.out.printf("<%d>",lst.get(i));
			else if (i==0){
				System.out.print("<"+lst.get(i)+", ");
			}
			else if (i==lst.size()-1)
				System.out.print(lst.get(i)+">");
			else
				System.out.print(lst.get(i)+", ");
		}
	}

	private static void solution(int N, int K){
		int count = 0;

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (!q.isEmpty()){
			count++;
			int x = q.poll();
			if (count%K==0) lst.add(x);
			else q.offer(x);
		}

	}
}