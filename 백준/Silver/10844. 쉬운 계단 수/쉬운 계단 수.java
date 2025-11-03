import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] d = new long[N+1][10];
		Arrays.fill(d[1],1);
		d[1][0] = 0;

		long k = 1_000_000_000;
		for (int i=2;i<=N;i++){
			for (int j=0;j<10;j++){
				if (j==0) d[i][j] = d[i-1][j+1] % k;
				else if (j==9) d[i][j] = d[i-1][j-1] % k;
				else d[i][j] = (d[i-1][j-1]+d[i-1][j+1]) %k;
			}
		}
		long answer = 0;
		for (int i = 0; i < 10; i++) {
			answer = (answer+d[N][i])%k;
		}
		System.out.print(answer);
	}
}
