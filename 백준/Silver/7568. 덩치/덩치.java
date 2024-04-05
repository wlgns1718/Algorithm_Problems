import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
//    static PriorityQueue<Human> pq = new PriorityQueue<>((o1,o2)-> o2.w - o1.w);
    static class Human{
        int w;
        int t;
        int num;
        public Human(int w, int t){
            this.w = w;
            this.t = t;
        }
        public void setNum(int num){
            this.num = num;
        }
    }
    static List<Human> ls = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int t = Integer.parseInt(input[1]);
            ls.add(new Human(w,t));
        }
        for(int i = 0; i < N; i++){
            Human cur = ls.get(i);
            int temp = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                Human h = ls.get(j);
                if(cur.w < h.w && cur.t < h.t) temp++;
            }
            cur.num = temp + 1;
        }
        for(int i = 0; i < N; i++){
            Human cur = ls.get(i);
            sb.append(cur.num);
            if(i != N - 1) sb.append(" ");
        }
        System.out.println(sb);
    }
}