import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            String s = sc.next();
            System.out.println(isVPS(s)?"YES":"NO");
        }
    }

    public static boolean isVPS(String s){
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c=='(') stack.push(0);
            else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}