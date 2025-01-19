import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> stk = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int cur = 1;
		boolean isValid = true;

		for (int i=0;i<n;i++){
			int key = Integer.parseInt(br.readLine());

			if (key<cur){ // 찾는값이 넣으려는 값보다 작으면
				if (stk.isEmpty()||stk.peek()!=key){ // 스택 최상단에 찾는 값 없을 경우
					isValid = false; break;
				}
			} else {
				while (cur<=key){// 찾는값이 현재값보다 작거나 같을 때까지 반복
					stk.push(cur++);
					sb.append("+\n");
				}
			}
			stk.pop();
			sb.append("-\n");
		}
		if (isValid) System.out.println(sb);
		else System.out.println("NO");
	}
}