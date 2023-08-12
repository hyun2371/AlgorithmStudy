class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int ind1=0, ind2 = 0;
        for (int i=0;i<goal.length;i++){
            
            if (ind1<cards1.length&&goal[i].equals(cards1[ind1])){
                ind1++; continue;
            }
            if (ind2<cards2.length&&goal[i].equals(cards2[ind2])){
                ind2++; continue;
            } 
            return "No";
            
        }
        return "Yes";
    }
}
