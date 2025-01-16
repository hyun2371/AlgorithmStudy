import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int[] alpha = new int[26]; // 알파벳 빈도수 저장

		for (char c: s1.toCharArray()){
			alpha[c-'a']++;
		}

		for (char c: s2.toCharArray()){
			alpha[c-'a']--;
		}

		int answer = 0;
		for (int x : alpha){
			answer+=Math.abs(x);
		}
		System.out.println(answer);
	}
}