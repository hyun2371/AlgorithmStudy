import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			long n = Long.parseLong(br.readLine());
			while (true){
				if (isSosu(n)) break;
				n++;
			}
			sb.append(n).append("\n");
		}
		System.out.print(sb);
	}

	private static boolean isSosu(long num){
		if (num==0||num==1) return false;
		if (num==2) return true;
		for (long i = 2; i <=Math.sqrt(num); i++) {
			if (num%i==0) return false;
		}
		return true;
	}
}