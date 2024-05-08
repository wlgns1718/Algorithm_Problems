import java.util.*;
import java.io.*;

public class Main {
    static int N, sero[], garo[];
    static int max_height, max_width;
    static List<Info> ls = new ArrayList<>();
    static class Info{
        int dir;
        int l;
        public Info(int dir, int l){
            this.dir = dir;
            this.l = l;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init(br);
        Arrays.sort(sero);
        Arrays.sort(garo);
        max_height = sero[2];
        max_width = garo[2];

        int temp = -1;
        for(int i = 0; i < 5; i++){
            if(ls.get(i).l == max_height || ls.get(i).l == max_width){
                if(ls.get(i+1).l == max_height || ls.get(i+1).l == max_width){
                    temp = i + 1;
                    break;
                }
            }
        }
        int answer = max_height * max_width;
        if(temp == -1) temp = 0;
        System.out.println((answer - sol(temp + 1)) * N);

    }
    private static int sol(int temp){
        if(temp == 6) temp = 0;

        int dir = ls.get(temp).dir;
        if(dir == 3 || dir == 4){

            int h = max_height - ls.get(temp).l;
            temp ++;
            if(temp == 6) temp = 0;
            int w = ls.get(temp).l;
            return h * w;

        }
        else{
            int w = max_width - ls.get(temp).l;
            temp ++;
            if(temp == 6) temp = 0;
            int h = ls.get(temp).l;
            return w * h;
        }
    }
    private static void init(BufferedReader br){
        try {
            N = Integer.parseInt(br.readLine());
            sero = new int[3];
            garo = new int[3];
            String[] input;
            int idx_sero = 0;
            int idx_garo = 0;
            for(int i = 0; i < 6; i++){
                input = br.readLine().split(" ");
                int dir = Integer.parseInt(input[0]);
                int l = Integer.parseInt(input[1]);
                ls.add(new Info(dir, l));

                if(dir == 3 || dir == 4){
                    sero[idx_sero++] = l;
                }
                else{
                    garo[idx_garo++] = l;
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}