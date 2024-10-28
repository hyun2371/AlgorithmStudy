import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		long answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] bags = new int[K];
		List<Jewel> jewels = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels.add(new Jewel(M, V));
		}
		// 무게 오름차순, 가격 내림차순
		jewels.sort((j1, j2) -> {
			int c = Integer.compare(j1.weight, j2.weight);
			if (c != 0)
				return c;
			c = Integer.compare(j2.price, j1.price);
			return c;
		});

		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags); // 오름차순 정렬

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0, j = 0; i < K; i++) {
			while (j < N && bags[i] >= jewels.get(j).weight) { // 가방이 용량 초과하지 않을 때까지 더하기
				pq.add(jewels.get(j).price);
				j++;
			}
			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
        System.out.println(answer);
	}
}

class Jewel {
	int weight;
	int price;

	public Jewel(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
}