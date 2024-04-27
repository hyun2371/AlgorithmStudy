import java.io.*;
import java.util.*;
class Main {	
  public static void main(String[] args) throws IOException{
    double answer = 0.0; int t_total=0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    Map<String, Double> m = new HashMap<>();
    m.put("A+",4.5);
    m.put("A0",4.0);
    m.put("B+",3.5);
    m.put("B0",3.0);
    m.put("C+",2.5);
    m.put("C0",2.0);
    m.put("D+",1.5);
    m.put("D0",1.0);
    m.put("F",0.0);
    
    for (int i=0;i<20;i++){
      String[] input = br.readLine().split(" ");
      String s = input[0];
      double t = Double.parseDouble(input[1]);
      String g = input[2];
      
      if (g.equals("P")) continue;
      answer+=m.get(g)*t; 
      t_total+=t;
    }
    System.out.printf("%.6f",answer/t_total);
  }
}