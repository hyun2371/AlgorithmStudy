import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int num = sc.nextInt();
		if (num==1||num==3) {
			System.out.println(-1);
			return;
		}
		for (int i=num/5;i>=0;i--){
			int remain = num-5*i;
			if (remain%2==0){
				cnt = i+remain/2;
				break;
			}
		}
		System.out.print(cnt);
	}
}