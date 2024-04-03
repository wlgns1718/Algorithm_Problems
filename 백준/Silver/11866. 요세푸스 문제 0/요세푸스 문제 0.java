import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        int idx = 0;
        sb.append("<");
        List<Integer> ls = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            ls.add(i);
        }

        while(ls.size() >= 2){
            idx += K;
            while(idx >= ls.size()){
                idx -= ls.size();
            }
            sb.append(ls.remove(idx)).append(", ");
        }
        sb.append(ls.remove(0));
        sb.append(">");
        System.out.println(sb);
    }
}