import java.io.*;
import java.util.*;

class Main {
    static int N, start, end, jump, answer = 0;
    static class Info{
        int start;
        int end;
        public Info(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return "start = " + start + " end = " + end;
        }
    }
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) ->{
        if(o1.start == o2.start){
            return o1.end - o2.end;
        }
        else{
            return o1.start - o2.start;
        }
    });
    static List<Info> ls = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        /*
        1. 끊어지지 않을 때 까지 pop(start, end 갱신)
        2. 끊어진다면 start 갱신, end + 점프가능 거리로 갱신
         */
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            pq.offer(new Info(s, e));
        }
        for(int i = 0; i < N; i++){
            Info info = pq.poll();
            if(i == 0){
                start = info.start;
                end = info.end;
            }
            else{
                if(end >= info.start){
                    end = Math.max(end, info.end);
                }
                else{
                    ls.add(new Info(start, end));
                    start = info.start;
                    end = info.end;
                }
            }
        }
        ls.add(new Info(start, end));
        answer = 0;
        jump = 0;
        for(int i = 0; i < ls.size(); i++){
            if(jump >= ls.get(i).start){
                answer = i;
                jump = Math.max(jump, ls.get(i).end + (ls.get(i).end - ls.get(i).start));
            }
        }

        System.out.println(ls.get(answer).end);
    }
}