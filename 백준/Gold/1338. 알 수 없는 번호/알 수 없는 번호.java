import java.io.*;
import java.util.*;

public class Main {
    static List<Long> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정답이 있을 수 있는 범위
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if(a > b){
            long temp = a;
            a = b;
            b = temp;
        }

        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long left = a / x;
        long right = b / x;
        boolean flag = true;

        x = Math.abs(x);

        if( y >= Math.abs(x) || y < 0){
            flag = false;
        }
        if(flag){
            for(long i = left - 2; i <= right; i++){
                long temp = i * x + y;
                if(temp >= a && temp <= b){
                    if(!answer.isEmpty()){
                        flag = false;
                        break;
                    }
                    else{
                        answer.add(temp);
                    }
                }
            }
        }

        if(flag && !answer.isEmpty()){
            System.out.println(answer.get(0));
        }
        else{
            System.out.println("Unknwon Number");
        }
    }
}