import java.util.*;

class Main {	
  public String solution(String str){
    String answer = "";
    for (char c : str.toCharArray()){
      if (Character.isAlphabetic(c)){
        if ((c>='a'&&c<'a'+13)||(c>='A' &&c<'A'+13))
          answer+=(char)(c+13);
        else
          answer+=(char)(c-13);
      }
      else answer+=c;
    }
    return answer;
  }

  public static void main(String[] args){
    Main t = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(t.solution(str));
  }
}