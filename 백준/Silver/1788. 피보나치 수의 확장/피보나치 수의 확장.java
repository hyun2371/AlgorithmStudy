import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(fibo(n));
	}

	private static String fibo(int n){
		StringBuilder sb = new StringBuilder();
		int k = Math.abs(n);
		int fn;
		final int MOD = 1_000_000_000;
		int[] d = new int[k+1];

		d[0] = 0;
		if (n==0) fn = 0;

		else if(n>0){
			d[1] = 1;
			for (int i=2;i<=n;i++){
				d[i] = (d[i-1]+d[i-2])%MOD;
			}
			fn = d[n];
		}
		else {
			d[1] = 1;
			for (int i=2;i<=k;i++){
				d[i] = (d[i-2]-d[i-1])%MOD;
			}
			fn = d[k];
		}
		
		if (fn==0) sb.append(0);
		else if (fn>0) sb.append(1);
		else sb.append(-1);
		sb.append("\n").append(Math.abs(fn));

		return sb.toString();
	}
}