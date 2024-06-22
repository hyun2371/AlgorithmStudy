import java.io.*;
class Main {
    public int[] solution(String s) { 
        int[] arr = new int[s.length()];
        for (int i=0;i<s.length();i++){
            arr[i] = s.charAt(i)-'0';
        }

        for (int i=1;i<arr.length;i++){
            int tmp = arr[i], j;
            for (j=i-1;j>=0;j--){
                if (arr[j]<tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new
        OutputStreamWriter(System.out));

        String s = br.readLine();
        Main t = new Main();

        for (int x : t.solution(s)){
            bw.write(String.valueOf(x));
        }
        br.close();
        bw.flush();
    }
}