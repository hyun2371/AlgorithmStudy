class Solution {
    public int solution(String[] order) {
        
        int answer =0;
        for (String o : order){
            if (o.equals("anything")){
                answer+=4500;
                continue;
            }
            o = o.replace("ice","");
            o = o.replace("hot","");
            
            if (o.equals("cafelatte")) answer+=5000;
            else answer+=4500;
        }
        return answer;
    }
}