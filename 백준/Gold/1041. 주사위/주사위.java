import java.util.*;
import java.io.*;


public class Main {
    static Long N;
    static Long[] num = new Long[6];
    static int[][] test_case = {{0,1,2},{0,2,4},{0,1,3},{0,3,4},{3,4,5},{1,2,5},{1,3,5},{2,4,5}};
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        Long answer = Long.MAX_VALUE;
        N = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 6; i++){ //주사위 값 받기
            num[i] = Long.parseLong(st.nextToken());
        }
        List<List<Long>> dice_case = new ArrayList<>();

        for(int[] tc : test_case){
            List<Long> list = new ArrayList<>();
            list.add(num[tc[0]]);
            list.add(num[tc[1]]);
            list.add(num[tc[2]]);
            list.sort((o1, o2) -> Math.toIntExact(o1 - o2));
            dice_case.add(list);
        }
        dice_case.sort(new Comparator<List<Long>>() {
            @Override
            public int compare(List<Long> o1, List<Long> o2) {
                if(o1.get(0) == o2.get(0)){
                    if(o1.get(1) == o2.get(1)){
                        return (int) (o1.get(2) - o2.get(2));
                    }
                    else{
                        return (int) (o1.get(1) - o2.get(1));
                    }
                }
                else{
                    return (int) (o1.get(0) - o2.get(0));
                }
            }
        });

        if(N == 1){
            Arrays.sort(num, new Comparator<Long>(){
                @Override
                public int compare(Long o1, Long o2){
                    return (int) (o1-o2);
                }
            });
            int temp = 0;
            for(int i = 0; i < 5; i++){
                temp += num[i];
            }
            System.out.println(temp);
        }
        else{
            List<Long> answer_list = dice_case.get(0);
            answer = answer_list.get(0) * (5 * (N * N) - 8 * N + 4) + answer_list.get(1) * (8 * N - 8) + answer_list.get(2) * 4;
            System.out.println(answer);
        }

    }



}