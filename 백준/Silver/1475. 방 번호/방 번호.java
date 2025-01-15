import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = String.valueOf(n);
		int[] arr = new int[10]; // 빈도수 저장

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c=='6'||c=='9'){ // 6,9는 치환 가능 -> 6,9가 나오면 두 빈도수 중 최솟값++
				if (arr[6]>arr[9]) arr[9]++;
				else arr[6]++;
			}
			else {
				arr[c-'0']++;
			}
		}
		// 정렬해서 가장 큰 값 반환
		Arrays.sort(arr);
		System.out.println(arr[9]);
	}
}