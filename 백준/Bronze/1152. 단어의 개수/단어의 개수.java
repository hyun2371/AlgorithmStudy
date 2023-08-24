import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int answer = 0;
        for (String str : s.split(" ")){
            if (str.equals("")){
                continue;
            }
            answer++;
        }
        System.out.println(answer);
    }
}