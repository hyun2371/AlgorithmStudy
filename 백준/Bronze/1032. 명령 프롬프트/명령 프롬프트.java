import java.util.*;

class Main {	
  public String solution(int n, String[] arr){
    char[] answer = arr[0].toCharArray();
    for (int i=1;i<n;i++){ // 2번째 arr부터
      for (int j=0;j<arr[i].length();j++){//arr 각 문자
        if (answer[j]!=arr[i].charAt(j))
          answer[j] = '?';
      }
    }
    
    return String.valueOf(answer);
  }


	public static void main(String[] args){
    Main t = new Main();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for (int i=0;i<n;i++){
      arr[i] = sc.next();
    }
    System.out.println(t.solution(n,arr));
	}
}