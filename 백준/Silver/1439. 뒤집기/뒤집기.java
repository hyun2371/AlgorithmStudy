import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] arr = s.toCharArray();
		int zCnt=0,oCnt=0;

		if (arr[0]=='1') zCnt++;
		else oCnt++;

		for (int i=1;i<arr.length;i++){
			if (arr[i-1]=='1'&&arr[i]=='0') oCnt++;
			else if (arr[i-1]=='0'&&arr[i]=='1') zCnt++;
		}
		System.out.println(Math.min(zCnt,oCnt));
	}
}