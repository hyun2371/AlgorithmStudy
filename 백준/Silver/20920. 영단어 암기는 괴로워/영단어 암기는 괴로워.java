import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.length()>=M)
				map.put(s, map.getOrDefault(s, 0)+1);
		}

		List<Word> words = new ArrayList<>();
		for (String s: map.keySet()){
			words.add(new Word(s,map.get(s)));
		}
		Collections.sort(words);
		StringBuilder sb = new StringBuilder();
		for (Word w : words){
			sb.append(w.s).append("\n");
		}
		System.out.print(sb);
	}
}

class Word implements Comparable<Word>{
		String s;
	int cnt;
	int len;

	public Word(String s, int cnt) {
		this.cnt = cnt;
		this.s = s;
		this.len = s.length();
	}

	//빈도 내림차순, 길이 내림차순, 알파벳 오름차순
	public int compareTo(Word o){
		if (this.cnt!=o.cnt) return o.cnt-this.cnt;
		if (this.len!=o.len) return o.len-this.len;
		return this.s.compareTo(o.s);
	}
}