import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()){
				case "push" : {
					stk.push(Integer.parseInt(st.nextToken())); break;
				}
				case "top" : {
					if (stk.isEmpty())
						sb.append(-1);
					else
						sb.append(stk.peek());
					sb.append("\n");
					break;
				}
				case "size" : {
					sb.append(stk.size()).append("\n"); break;
				}
				case "empty" : {
					if (stk.isEmpty()) sb.append(1);
					else sb.append(0);
					sb.append("\n");
					break;
				}
				default: {
					if (stk.isEmpty())
						sb.append(-1);
					else
						sb.append(stk.pop());
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}