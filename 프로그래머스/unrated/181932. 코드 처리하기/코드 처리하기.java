class Solution {
    public String solution(String code) {
        
        String ret = "";
        int mode =0;
        
        for (int i =0;i<code.length();i++){
            String s = code.substring(i,i+1);
               
            if (mode==0){
                if (!s.equals("1")){
                    if (i%2==0)
                        ret+=s;
                } else{
                    mode=1;
                }
            } else {
                if (!s.equals("1")){
                    if (i%2!=0)
                        ret+=s;
                } else {
                    mode=0;
                }
            }
        }
        
        if (ret.length()==0) return "EMPTY";
        return ret.toString();
        
    }
}