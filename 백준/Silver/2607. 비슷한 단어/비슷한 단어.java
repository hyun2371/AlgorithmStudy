import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String origin = sc.next();
		int[] alpha = new int[26];
		for (char c : origin.toCharArray()) {
			alpha[c-'A']++;
		}
		int answer = 0;
		for (int i = 1; i < n; i++) {
			String cmp = sc.next();
			if (isSimilar(origin, cmp, alpha)) answer++;
		}
		System.out.print(answer);
	}
	private static boolean isSimilar(String origin, String cmp, int[] alpha){
		int[] copy = Arrays.copyOf(alpha, alpha.length);
		int matchCnt=0;
		for (char c : cmp.toCharArray()){
			if (copy[c-'A']>0) {
				copy[c-'A']--;
				matchCnt++;
			}
		}
		//i) 문자 하나 더하면 원본과 일치
		if (cmp.length()==origin.length()-1&&matchCnt==origin.length()-1) return true;
		//ii) 문자 하나 빼면 원본과 일치
		if (cmp.length()==origin.length()+1&&matchCnt==origin.length()) return true;
		//iii) 완전 일치하거나 문자열 하나 대체
		if (cmp.length()==origin.length()&&(matchCnt==origin.length()||matchCnt==origin.length()-1)) return true;
		return false;
	}
}