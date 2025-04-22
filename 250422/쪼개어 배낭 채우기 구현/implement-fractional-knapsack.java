import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Jewel> lst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            lst.add(new Jewel(w,v));
        }
        
        Collections.sort(lst);

        double total = 0.0;
        for (Jewel j : lst){
            if (m>=j.weight){
                m-=j.weight;
                total+=j.value;
            }
            else{
                total+=j.vps*m;
                break;
            }
        }
        System.out.printf("%.3f",total);
    }
}

class Jewel implements Comparable<Jewel>{
    int weight;
    int value;
    double vps; // 1kg당 보석 가치

    public Jewel(int weight, int value){
        this.weight = weight;
        this.value = value;
        vps = value*1.0/weight;
    }

    @Override
    public int compareTo(Jewel j){ // vps 내림 차순
        return Double.compare(j.vps,this.vps);
    }
}