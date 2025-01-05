import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static int N, sum = 0, pre;
    static class Choco implements Comparable<Choco>{
        char type;
        int cnt;

        public Choco(char type, int cnt){
            this.type = type;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Choco choco){
            if(this.cnt == choco.cnt){
                return this.type - choco.type;
            }
            return choco.cnt - this.cnt;
        }

        @Override
        public String toString(){
            return this.type + "=" + this.cnt;
        }
    }
    static char[] type = {'H', 'T', 'C', 'K', 'G'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        Choco[] choco = new Choco[5];

        for(int i = 0; i < 5; i++){
            choco[i] = new Choco(type[i], Integer.parseInt(input[i]));
            sum += choco[i].cnt;
        }
        N = Integer.parseInt(br.readLine());



        for(int i = 0; i < N; i++){
            if(sum % 10 == 0 || sum % 10 == 1){
                pre = 10;
            }
            else{
                pre = sum % 10;
            }

            input = br.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                int temp = Integer.parseInt(input[j]);
                sum -= temp;

                Loop3:
                for(int p = 0; p < 5; p++){
                    if(choco[p].type == type[j]){
                        choco[p].cnt -= temp;
                        break Loop3;
                    }
                }
            }
            //현재 남아있는 초콜릿 총 개수, pre값 진법으로 나타내기
            sb.append(sol()).append("7H").append("\n");
            Arrays.sort(choco);
            if(sum == 0){
                sb.append("NULL").append("\n");
                continue;
            }
            for(int j = 0; j < 5; j++){
                if(choco[j].cnt != 0){
                    sb.append(choco[j].type);
                }
                else{
                    break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static String sol(){
        return Integer.toString(sum, pre);
    }
}