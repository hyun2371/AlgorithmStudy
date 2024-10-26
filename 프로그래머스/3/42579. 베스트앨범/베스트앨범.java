import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>(); 
        Map<String, Integer> genreMap = new TreeMap<>(Collections.reverseOrder()); //장르별 플레이수 내림차순 정렬
        List<Music> musicList = new ArrayList<>(); // 노래 정보 저장
        
        for (int i=0;i<genres.length;i++){
            genreMap.put(genres[i],genreMap.getOrDefault(genres[i],0)+plays[i]); // 장르별 플레이수 구하기
            musicList.add(new Music(i,genres[i],plays[i])); // 인덱스, 장르, 플레이 수
        }
        
        Collections.sort(musicList, new Comparator<Music>() {
            @Override
            public int compare(Music m1, Music m2) {
                // 장르별 
                int c = Integer.compare(genreMap.get(m2.genre), genreMap.get(m1.genre));
                if (c != 0) return c;
                
                // 재생횟수 내림차순
                c = Integer.compare(m2.cnt, m1.cnt);
                return c;
            }
        });
        
        String preGenre=""; // 이전 장르
        int genreCnt = 0; // 연속된 장르 등장수
    
  
        for (int i=0;i<musicList.size();i++){
            if (musicList.get(i).genre.equals(preGenre)){ 
                genreCnt++;
                if (genreCnt>=3) continue; // 최대 2곡
            } else { // 장르 갱신
                genreCnt = 1;
                preGenre = musicList.get(i).genre;
            }
            answer.add(musicList.get(i).ind); // 정답 배열에 인덱스 삽입
        }
        
        // list -> int[]
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
    
}

class Music{
    int ind;
    String genre;
    int cnt;
    
    public Music(int ind, String genre, int cnt){
        this.ind = ind;
        this.genre = genre;
        this.cnt = cnt;
    }
    //디버깅
    @Override
    public String toString() {
        return String.format("Music{ind=%d, genre='%s', cnt=%d}", ind, genre, cnt);
    }
}