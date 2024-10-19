import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0; //배열에 target있는지 검증
        return BFS(begin, target, words);
    }
    
    public int BFS(String begin, String target, String[] words){
        Queue<WordDis> q = new LinkedList<>();
        q.offer(new WordDis(begin, 0));
        boolean[] visited = new boolean[words.length]; // 방문 여부
        
        while (!q.isEmpty()){
            WordDis cur = q.poll();
            
            for (int i=0;i<words.length;i++){ //words에 대해 반복
                String word = words[i];
                if (visited[i]) continue; // 한번만 방문
                
                if (isDifferOne(cur.word, word)) {
                    if (word.equals(target)) return cur.dis+1;
                    q.offer(new WordDis(word, cur.dis+1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    // 문자열에서 하나의 문자만 다른지 여부 반환
    public boolean isDifferOne(String cmp, String target){
        int cnt = 0;
        for (int i=0;i<cmp.length();i++){
            if (cmp.charAt(i)!=target.charAt(i)){
                cnt++;
                if (cnt>1) return false;
            }
        }
        if (cnt==1) return true;
        return false;
    }
}

class WordDis{
    String word; // 단어
    int dis; // 변환 수
    public WordDis(String word, int dis){
        this.word = word;
        this.dis = dis;
    }
}