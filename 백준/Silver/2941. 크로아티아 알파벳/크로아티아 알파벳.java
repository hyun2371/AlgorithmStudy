import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.replaceAll("c=","0")
                .replaceAll("c-","0")
                .replaceAll("dz=","0")
                .replaceAll("d-","0")
                .replaceAll("lj","0")
                .replaceAll("nj","0")
                .replaceAll("s=","0")
                .replaceAll("z=","0");
        System.out.println(s.length());

    }
}