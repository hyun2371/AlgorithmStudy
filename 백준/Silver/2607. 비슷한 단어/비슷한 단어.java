import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] origin = new int[26];
		for (char c : sc.next().toCharArray()) {
			origin[c-'A']++;
		}
		int answer = 0;
		for (int i = 1; i < n; i++) {
			String s = sc.next();
			if (isSimilar(s, origin)) answer++;
		}
		System.out.println(answer);
	}
	private static boolean isSimilar(String s, int[] origin){
		int[] copy = Arrays.copyOf(origin, origin.length);

		int extra = 0;
		int missing = 0;

		for (char c : s.toCharArray()) {
			int idx = c-'A';
			if (copy[idx]>0) copy[idx]--;
			else extra++;
		}

		for (int cnt:copy){
			missing+=cnt;
		}
		return extra<=1&&missing<=1;
	}
}