import java.io.*;
//버블 정렬
class Main {
    public int[] solution(String s) { 
        int[] arr = new int[s.length()];
        for (int i=0;i<s.length();i++){
            arr[i] = s.charAt(i)-'0';
        }
        int n = arr.length;
        for (int i=0;i<n-1;i++){
            for (int j=0;j<n-i-1;j++){ //뒤에서 i번째만큼 이미 정렬됨(고정)
                if (arr[j]<arr[j+1]){
                    int tmp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = tmp;
                }
            }
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
        bw.close();
    }
}