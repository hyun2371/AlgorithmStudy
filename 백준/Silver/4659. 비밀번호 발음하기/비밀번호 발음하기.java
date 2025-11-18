import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		while (!s.equals("end")) {
			if (isSatisfied(s)) sb.append("<").append(s).append("> is acceptable.\n");
			else sb.append("<").append(s).append("> is not acceptable.\n");
			s = br.readLine();
		}
		System.out.print(sb);
	}

	private static boolean isSatisfied(String s) {
		Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
		int mCnt = 0, mSerialCnt = 0, jSerialCnt = 0;
		char prev = '0';
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (set.contains(cur)) {
				mCnt++;
				mSerialCnt++;
				jSerialCnt = 0;
			} else {
				jSerialCnt++;
				mSerialCnt = 0;
			}
			if (jSerialCnt >= 3 || mSerialCnt >= 3)
				return false;
			if (cur == prev && cur != 'e' && cur != 'o')
				return false;
			prev = cur;
		}
		return mCnt > 0;
	}

}