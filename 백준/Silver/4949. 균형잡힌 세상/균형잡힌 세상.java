import java.io.*;
import java.util.*;
class Main {
    public String validate(String str){
        Stack<Character> stk = new Stack<>();
        for (char c : str.toCharArray()){
            if (c=='['||c=='(') stk.push(c);
    
            else if (c==']') {
                if (stk.size()==0||stk.peek()!='[')
                    return "no";
                stk.pop();
            }
            else if (c==')') {
                if (stk.size()==0||stk.peek()!='(')
                    return "no";
                stk.pop();
            }
        }
        return stk.isEmpty()? "yes" : "no";
    }
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       while (true){
          String s = br.readLine();
           if (s.equals(".")) break;
           sb.append(t.validate(s)).append("\n");
       }

       System.out.println(sb.toString());
    }
}