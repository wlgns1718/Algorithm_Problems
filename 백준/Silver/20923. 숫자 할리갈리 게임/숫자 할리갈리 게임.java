import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        Deque<Integer> dodo = new LinkedList<>();
        Deque<Integer> su = new LinkedList<>();

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            dodo.offer(Integer.parseInt(input[0]));
            su.offer(Integer.parseInt(input[1]));
        }
        Deque<Integer> do_ground = new LinkedList<>();
        Deque<Integer> su_ground = new LinkedList<>();

        boolean flag = true;

        for(int i = 0; i < M; i++){
            if(flag){
                flag = !flag;
                do_ground.offer(dodo.pollLast());
                if(dodo.isEmpty()){
                    sb.append("su");
                    break;
                }
            }
            else{
                flag = !flag;
                su_ground.offer(su.pollLast());
                if(su.isEmpty()){
                    sb.append("do");
                    break;
                }
            }
            int su_temp = (su_ground.isEmpty()) ? 0 : su_ground.peekLast();
            int do_temp = (do_ground.isEmpty()) ? 0 : do_ground.peekLast();
            if((do_temp == 5 || su_temp == 5)){
                //도도가 종을 친다.
                //First부터 Last를 do First에 넣기
                while(!su_ground.isEmpty()){
                    dodo.addFirst(su_ground.pollFirst());
                }
                while(!do_ground.isEmpty()){
                    dodo.addFirst(do_ground.pollFirst());
                }
            }
            else if((!do_ground.isEmpty() && !su_ground.isEmpty()) && do_ground.peekLast() + su_temp == 5){
                while(!do_ground.isEmpty()){
                    su.addFirst(do_ground.pollFirst());
                }
                while(!su_ground.isEmpty()){
                    su.addFirst(su_ground.pollFirst());
                }
            }

        }

        if(sb.length() == 0){
            if(su.size() == dodo.size()) sb.append("dosu");
            else if(su.size() > dodo.size()) sb.append("su");
            else sb.append("do");
        }

        System.out.println(sb);
    }

}