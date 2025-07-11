class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees){
            if (isValid(tree,skill)) answer++;
        }

        return answer;
    }
    
    private static boolean isValid(String tree , String skill){
        int pointer = 0;
        
        for (char t: tree.toCharArray()){
            if (skill.contains(t+"")){ //선행 스킬 트리에 있을 경우
                if (t==skill.charAt(pointer)) pointer++; //pointer가 가리키는 스킬이 존재해야함
                else return false;
            }
        }
        
        return true;
    }
}