import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Stack<Character> stack = new Stack<>();
    static class Info{
        String init;
        int num;

        public Info(String init, int num){
            this.init = init;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "init='" + init + '\'' +
                    ", num=" + num +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Deque<Info> infos = new ArrayDeque<>();
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            infos.add(new Info(input[0], Integer.parseInt(input[1])));
        }
        while(infos.size() > 1){
            Info cur = infos.pollFirst();
            for(int temp = 0; temp < cur.num - 1; temp++) {
                Info info = infos.pollFirst();
                infos.addLast(info);
            }
            infos.pollFirst();
        }
        System.out.println(infos.peek().init);
    }
}