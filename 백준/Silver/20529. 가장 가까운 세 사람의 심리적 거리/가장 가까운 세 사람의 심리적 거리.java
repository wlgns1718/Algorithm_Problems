import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visit;
    static List<String> ls;
    static int answer, combi[] = new int[3];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            HashMap<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            ls = new ArrayList<>();
            answer = Integer.MAX_VALUE;

            for(String s : input){
                if(!map.containsKey(s)){
                    map.put(s, 1);
                    ls.add(s);
                    continue;
                }
                if(map.get(s) == 3) continue;
                map.replace(s, map.get(s) + 1);
                ls.add(s);
            }
            sol(0, 0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    private static void sol(int idx, int start){

        if(idx == 3){
            int temp = 0;
            for(int i = 0; i < 3; i++){
                for(int j = i+1; j < 3; j++){

                    for(int p = 0; p < 4; p++){
                        if(ls.get(combi[i]).charAt(p) != ls.get(combi[j]).charAt(p)) temp++;
                    }
                }
            }
            if(answer > temp) answer = temp;
            return;
        }

        for(int i = start; i < ls.size(); i++){
            combi[idx] = i;
            sol(idx + 1, i + 1);
        }
    }
}