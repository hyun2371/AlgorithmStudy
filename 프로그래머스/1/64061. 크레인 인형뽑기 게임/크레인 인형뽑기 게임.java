import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; 
        Stack<Integer> stk = new Stack<>();
        
        for (int move : moves){ 
            for (int i=0;i<board.length;i++){ //행
                if (board[i][move-1]!=0){
                    int tmp = board[i][move-1];
                    board[i][move-1]=0;
                    if (!stk.isEmpty() && tmp==stk.peek()){
                        answer+=2;
                        stk.pop();
                    } 
                    else stk.push(tmp);
                    break;
                }
            }
        }   
        return answer;
    }
}