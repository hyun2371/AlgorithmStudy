import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<Num> lst = new ArrayList<>();
        for (int x : numbers){
            lst.add(new Num(x));
        }
        Collections.sort(lst);
        if (lst.get(0).number==0) return "0";
        StringBuilder sb = new StringBuilder();
        for (Num num : lst){
            sb.append(num.number);
        }
        return sb.toString();
    }
    
}

class Num implements Comparable<Num>{
    int number;
    public Num(int number){
        this.number = number;
    }
    public int compareTo(Num o){
        String n1 = this.number+""+o.number;
        String n2 = o.number+""+this.number; 
        return n2.compareTo(n1);
    }
}