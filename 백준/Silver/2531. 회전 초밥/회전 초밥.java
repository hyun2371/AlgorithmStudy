import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); //연속개수
		int C = Integer.parseInt(st.nextToken()); //쿠폰번호

		int[] arr = new int[N+K];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < K; i++) {//원형
			arr[N+i] = arr[i];
		}

		Map<Integer, Integer> map = new HashMap<>(); //초밥번호, 개수 -> 2개 이상일때는 중복 없애되, 0개이면 제거하기 위해

		for (int i = 0; i < K; i++) {
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		}

		int answer = 0;
		for (int rt = K,lt=0; rt <arr.length; rt++,lt++) {
			//오른쪽 스시 추가
			map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);

			//왼쪽 스시 제거
			map.put(arr[lt],map.getOrDefault(arr[lt],0)-1);
			if (map.get(arr[lt])==0) map.remove(arr[lt]); //윈도우 안에 초밥 없으면 set에서도 제거

			map.put(C,map.getOrDefault(C,0)+1);
			answer = Math.max(map.size(), answer);
		}
		System.out.println(answer);
	}
}