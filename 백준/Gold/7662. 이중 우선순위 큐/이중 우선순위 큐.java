import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Long> max = new PriorityQueue<>((o1,o2)->{
        if(o1 < o2){
            return 1;
        }
        else{
            return -1;
        }
    });
    static PriorityQueue<Long> min = new PriorityQueue<>((o1, o2) -> {
        if(o1<o2){
            return -1;
        }
        else{
            return 1;
        }
    });

    static HashMap<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= TC; test_case++){
            int n = Integer.parseInt(br.readLine());
            map.clear();
            min.clear();
            max.clear();
            for(int i = 0; i < n; i++){
                String[] input = br.readLine().split(" ");
                long a = Long.parseLong(input[1]);
                if(input[0].equals("I")){
                    min.offer(a);
                    max.offer(a);
                    if(!map.containsKey(a)){
                        map.put(a, 1);
                        continue;
                    }
                    int temp = map.get(a);
                    map.replace(a, temp + 1);
                }
                else{
                    if(a == 1){
                        //최대값 삭제
                        while(!max.isEmpty()){
                            long max_val = max.poll();
                            if(map.get(max_val) == 0){
                                continue;
                            }
                            int temp = map.get(max_val);
                            map.replace(max_val, temp - 1);
                            break;
                        }

                    }
                    else{
                        //최소값 삭제
                        while(!min.isEmpty()){
                            long min_val = min.poll();
                            if(map.get(min_val) == 0){
                                continue;
                            }
                            int temp = map.get(min_val);
                            map.replace(min_val, temp - 1);
                            break;
                        }
                    }
                }
            }
            // 남아 있는 수 중에서 max, min 값 뽑기
            long max_val = Long.MIN_VALUE;
            long min_val = Long.MAX_VALUE;
            while(!max.isEmpty()){
                long temp = max.poll();
                if(map.get(temp) == 0){
                    continue;
                }
                max_val = temp;
                break;
            }
            while(!min.isEmpty()){
                long temp = min.poll();
                if(map.get(temp) == 0){
                    continue;
                }
                min_val = temp;
                break;
            }
            if(max_val == Long.MIN_VALUE && min_val == Long.MAX_VALUE){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(max_val).append(" ").append(min_val).append("\n");
            }

        }
        System.out.println(sb);
    }
}