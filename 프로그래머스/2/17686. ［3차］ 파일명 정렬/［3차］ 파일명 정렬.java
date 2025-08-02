import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        List<Part> parts = new ArrayList<>();
        for (String file : files){
            int tailStartIdx = getTailStartIdx(file);
            int tailEndIdx = getTailEndIdx(file,tailStartIdx);
            String head = file.substring(0,tailStartIdx).toLowerCase();
            int number = Integer.parseInt(file.substring(tailStartIdx, tailEndIdx));
            parts.add(new Part(file,head,number));
        }
        Collections.sort(parts);
        String[] answer = new String[parts.size()];
        int idx = 0;
        for (Part part : parts){
            answer[idx++] = part.file;
        }
        
        return answer;
    }
    
    private static int getTailStartIdx(String file) {
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) return i;
        }
        return file.length(); // fallback
    }
    
      private static int getTailEndIdx(String file, int tailStartIdx) {
        int tailEndIdx = tailStartIdx;
        int count = 0;
        while (tailEndIdx < file.length() && Character.isDigit(file.charAt(tailEndIdx)) && count < 5) {
            tailEndIdx++;
            count++;
        }
        return tailEndIdx;
    }
}
class Part implements Comparable<Part>{
    String file;
    String head;
    int number;
    
    public Part(String file,String head, int number){
        this.file = file;
        this.head = head;
        this.number = number;
    }
    
    public int compareTo(Part o){
        if (this.head.equals(o.head))
            return this.number - o.number;
        return this.head.compareTo(o.head);
    }
}