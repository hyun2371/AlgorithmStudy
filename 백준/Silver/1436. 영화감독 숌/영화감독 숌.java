import java.util.*;
class Main {	
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cnt =0, answer = 0;
    while (true){
      if (String.valueOf(answer).contains("666"))
        cnt++;
      if (cnt==n) break;
      answer++;
    }
    System.out.println(answer);
  }
}