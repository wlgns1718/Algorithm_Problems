import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    static Long P,Q;
    static HashMap<Long,Long> map = new HashMap<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map.put(0L,1L);
        System.out.println(sol(N));

    }
    public static Long sol(Long num){
        if(map.containsKey(num)){
            return map.get(num);
        }
        Long p = sol(num/P);
        Long q = sol(num/Q);
        map.put(num,p+q);
        return  p+q;
    }
}