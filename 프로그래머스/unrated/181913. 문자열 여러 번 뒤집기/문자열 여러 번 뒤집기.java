class Solution {
    public String solution(String my_string, int[][] queries) {

        for (int i=0;i<queries.length;i++){
            int start = queries[i][0], end = queries[i][1];
            
            StringBuilder rv = new StringBuilder(my_string.substring(start,end+1));
            rv = rv.reverse();
            
            my_string = my_string.substring(0,start)+rv.toString()
                +my_string.substring(end+1,my_string.length());
        }
        return my_string;
    }
}