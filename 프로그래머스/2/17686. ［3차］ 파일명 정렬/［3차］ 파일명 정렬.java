import java.util.*;


class Solution {
    
    static PriorityQueue<Data> pq = new PriorityQueue<>((o1,o2) ->{
        if(o1.head.equals(o2.head)){
            if(o1.number == o2.number){
                return o1.idx - o2.idx;
            }
            else{
                return o1.number - o2.number;
            }
        }
        else{
            return o1.head.compareTo(o2.head);
        }
    });
    
    static class Data{
        int idx;
        String fileName;
        String head;
        int number;
        public Data(int idx, String filename){
            this.idx = idx;
            this.fileName = filename;
            boolean tri = false;
            int index = 0;
            for(int i = 0; i < filename.length(); i++){
                if(filename.charAt(i) >= '0' && filename.charAt(i) <= '9'){
                    this.head = filename.substring(0, i).toLowerCase();
                    this.number = findNumber(i, filename);
                    break;
                }
            }
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        for(int i = 0; i < files.length; i++){
            pq.offer(new Data(i, files[i]));
        }
        int idx = 0;
        while(!pq.isEmpty()){
            Data data = pq.poll();
            answer[idx++] = data.fileName;
        }
        return answer;
    }
    private static int findNumber(int idx, String filename){
        StringBuilder sb = new StringBuilder();
        for(int i = idx; i < idx + 5; i++){
            if(i >= filename.length()) break;
            if((filename.charAt(i) < '0') || (filename.charAt(i)) > '9') break;
            sb.append(filename.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}