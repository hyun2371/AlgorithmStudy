class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] n = new int[2];
        int max_w = board[0]/2;
        int max_h = board[1]/2;
        for (String k : keyinput){
            if (k.equals("left")){
                if (n[0]-1>=-max_w)
                    n[0]--;
            } else if (k.equals("right")){
                if (n[0]+1<=max_w)
                    n[0]++;
            } else if (k.equals("down")){
                if (n[1]-1>=-max_h)
                    n[1]--;
            } else {
                if (n[1]+1<=max_h)
                    n[1]++;
            }
        }
        return n;
    }

}