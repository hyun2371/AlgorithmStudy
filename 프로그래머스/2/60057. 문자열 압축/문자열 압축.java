class Solution {
    public int solution(String s) {

		int answer = s.length(); // 문자열 줄이지 못하는 경우

		for (int l = 1; l <= s.length() / 2; l++) { // 자르는 단위
			StringBuilder sb = new StringBuilder();
			int cnt = 1; // 연속으로 몇 번 일치하는지
			String target = s.substring(0, l);

			for (int i = l; i <= s.length(); i += l) {
				String cur = s.substring(i, Math.min(i + l, s.length())); //0,3 3,6 6,8
				if (target.equals(cur)) {
					cnt++;
				} else {
					if (cnt == 1) { // 이전에 연속되지 않았을 경우
						sb.append(target);
					} else { // 연속된 경우
						sb.append(cnt).append(target);
					}
					target = cur;
					cnt = 1;
				}
			}
            sb.append(target);
			answer = Math.min(sb.length(), answer);
		}

		return answer;
    }
}