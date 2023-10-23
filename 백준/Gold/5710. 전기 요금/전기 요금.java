import java.util.*;
import java.io.*;


public class Main {
    static Long sum, diff, answer;

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while (true){
            st = new StringTokenizer(br.readLine());
            sum = Long.parseLong(st.nextToken());
            diff = Long.parseLong(st.nextToken());
            if(sum == 0 && diff == 0) return;

            Long total = getW(sum);
            Long start = 0L;
            Long end = total / 2;
            while(start <= end){
                Long mid = (start + end) / 2;

                Long a_cost = getCost(mid);
                Long b_cost = getCost(total-mid);

                Long b = Math.abs(a_cost - b_cost);
                if(b < diff){
                    end = mid - 1;
                }else if(b > diff){
                    start = mid + 1;
                }else{
                    System.out.println(a_cost);
                    break;
                }
            }

        }

    }
    private static Long getCost(Long cost){
        if(cost<=100){
            return cost * 2;
        }
        else if(cost<=10000){
            return 100*2 + (cost-100) * 3;
        } else if (cost <= 1000000) {
            return 100 * 2 + 9900 * 3 + (cost-10000) * 5;
        }
        else{
            return  100 * 2 + 9900 * 3 + 990000 * 5 + (cost - 1000000) * 7;
        }

    }
    private static Long getW(Long cost){
        if(cost <= 200){
            return cost / 2;
        }
        else if(cost <= ((3*10000) - 100)){
            return (cost - 200) / 3 + 100;
        }
        else if(cost <= (1000000 * 5) - (3*10000) - 100){
            return (cost - 29900) / 5 + 10000;

        }
        else{
            return (cost - 4979900) / 7 + 1000000;
        }
    }




}