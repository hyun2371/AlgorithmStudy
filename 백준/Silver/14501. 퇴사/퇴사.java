import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] t, p, d;
		t = new int[N + 1];
		p = new int[N + 1];
		d = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		d[1] = t[1] > N ? 0 : t[1];
		int answer = 0;
		for (int i = 1; i <= N; i++) { // i는 일자
			if (i + t[i] > N + 1)
				continue; // 퇴사 전에 상담 끝나야 함
			int prevMax = -1;
			for (int j = 0; j < i; j++) {
				if (j + t[j] > i) continue; // 전 상담과 병행 불가
				prevMax = Math.max(d[j], prevMax); // 현재 상담 포함하기 전 최대 수익
			}
			d[i] = prevMax + p[i];
			answer = Math.max(d[i], answer); //최대 수익
		}
		System.out.println(answer);
	}
}