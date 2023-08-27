import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i=0;i<n;i++){
            arr[i] = sc.next();
        }
        Arrays.sort(arr,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()) return 1;
                else if (o1.length()==o2.length()) return o1.compareTo(o2);
                else return -1;
            }
        });
        String tmp = "";
        for (String str:arr) {
            if (!str.equals(tmp)){
                System.out.println(str);
                tmp = str;
            }
        }
    }
}