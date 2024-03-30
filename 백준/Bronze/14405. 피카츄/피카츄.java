import java.util.*;

class Main {	
	public String solution(String str){
    String[] dic = {"pi", "ka", "chu"};
    for (String s : dic){
      str = str.replaceAll(s," ");
    }
    str = str.replaceAll(" ","");
    return str.length()==0?"YES":"NO";
  }

	public static void main(String[] args){
    Main t = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(t.solution(str));
	}
}