import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; int n = board[0].length;
        Stack<Integer> stk = new Stack<>();
        for (int x : moves){ //모든 move 수행
            int ind = 0;
            //인형 있을 때까지 ind 증가
            while (ind<n&& board[ind][x-1]==0) ind++;
            if (ind==n) continue;
            
            int k = board[ind][x-1]; // 뽑은 인형 저장
            board[ind][x-1]=0; // 뽑기 반영
            if (!stk.isEmpty()&&stk.peek()==k){ //연속된 같은 원소 있으면
                stk.pop(); // 터트리기
                answer+=2;
            } else stk.push(k); // 바구니 넣기
        }
        return answer;
    }
}