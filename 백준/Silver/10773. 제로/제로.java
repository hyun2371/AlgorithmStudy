import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> stk = new ArrayDeque<>();
		int K = sc.nextInt();
		int total = 0;
		for (int i = 0; i < K; i++) {
			int n = sc.nextInt();
			if (n==0) {
				total-=stk.pop();
			}
			else {
				stk.push(n);
				total+=n;
			}
		}
		System.out.println(total);
	}
}