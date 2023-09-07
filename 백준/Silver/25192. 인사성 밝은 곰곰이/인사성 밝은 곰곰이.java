import java.util.*;
public class Main {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        for (int i=0;i<n;i++){
            String input = sc.next();
            if (input.equals("ENTER"))
                hs = new HashSet<>();
            else {
                if (!hs.contains(input)) {
                    hs.add(input);
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }

}