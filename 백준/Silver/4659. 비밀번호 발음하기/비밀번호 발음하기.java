import java.util.*;
import java.io.*;

public class Main {
	static Set<Character> mSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s;
		while (!(s = br.readLine()).equals("end")){
			boolean isValid = false;
			sb.append("<").append(s).append(">");
			if (condition1(s)&&condition2(s)&&condition3(s)){
				isValid = true;
			}
			if (isValid){
				sb.append(" is acceptable.").append("\n");
			} else {
				sb.append(" is not acceptable.").append("\n");
			}
		}

		System.out.println(sb);
	}

	private static boolean condition1(String s){
		for (char c : s.toCharArray()) {
			if (mSet.contains(c)) return true;
		}
		return false;
	}

	private static boolean condition2(String s){
		int serialCnt = 1;
		boolean isM = mSet.contains(s.charAt(0));

		for (int i=1;i<s.length();i++){
			char cur = s.charAt(i);
			if ((mSet.contains(cur)&&isM)||(!mSet.contains(cur)&&!isM)){
				serialCnt++;
				if (serialCnt==3) return false;
			}
			else {
				serialCnt = 1;
			}
			isM = mSet.contains(cur);
		}
		return true;
	}

	private static boolean condition3(String s){
		for (int i=1;i<s.length();i++){
			char prev = s.charAt(i-1);
			char cur = s.charAt(i);
			if (prev==cur&&cur!='o'&&cur!='e') return false;
		}
		return true;
	}
}
