import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); //연속개수
		int C = Integer.parseInt(st.nextToken()); //쿠폰번호

		int[] arr = new int[2*N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {//원형
			arr[N+i] = arr[i];
		}

		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> sushi = new HashMap<>(); //초밥번호, 개수 -> 2개 이상일때는 중복 없애되, 0개이면 제거하기 위해

		for (int i = 0; i < K; i++) {
			set.add(arr[i]);
			sushi.put(arr[i],sushi.getOrDefault(arr[i],0)+1);
		}

		int answer = 0;
		for (int rt = K,lt=0; rt <2*N; rt++,lt++) {
			//오른쪽 스시 추가
			set.add(arr[rt]);
			sushi.put(arr[rt],sushi.getOrDefault(arr[rt],0)+1);
			
			//왼쪽 스시 제거
			sushi.put(arr[lt],sushi.getOrDefault(arr[lt],0)-1);
			if (sushi.get(arr[lt])==0) set.remove(arr[lt]); //윈도우 안에 초밥 없으면 set에서도 제거

			set.add(C); // 쿠폰 스시 추가
			answer = Math.max(set.size(), answer);
		}
		System.out.println(answer);
	}
}