import java.util.*;
import java.io.*;

public class Main {
    static int n, w, l;
    static class Truck{
        int weight;
        int time;
        public Truck(int weight, int time){
            this.time = time;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "weight=" + weight +
                    ", time=" + time +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);
        l = Integer.parseInt(input[2]);
        Queue<Truck> queue = new ArrayDeque<>();
        input = br.readLine().split(" ");
        int weight = 0;
        int answer = 0;
        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(input[i]);
            if(weight + cur <= l && queue.size() < w){
                queue.offer(new Truck(cur, answer++));
                weight += cur;
//                System.out.println(queue.toString());
                continue;
            }
            while(weight + cur > l || queue.size() >= w){
                Truck truck = queue.poll();
                weight -= truck.weight;
                if(truck.time + w > answer) answer += (truck.time + w - answer);
            }
            queue.offer(new Truck(cur, answer++));
            weight += cur;
//            System.out.println(queue.toString());
        }
        while(!queue.isEmpty()){
            Truck truck = queue.poll();
            if(truck.time + w > answer) answer += (truck.time + w - answer);
        }
        System.out.println(answer + 1);
    }

}