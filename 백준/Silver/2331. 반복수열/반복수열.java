import java.util.*;
import java.io.*;

public class Main {
    static int A, P;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        set.add(A);
        ls.add(A);
        int temp = A;
        while(true){
            temp = sol(temp);
            if(set.contains(temp)) break;
            set.add(temp);
            ls.add(temp);

        }
        for(int i = 0; i < ls.size(); i++){
            if(ls.get(i) == temp){
                System.out.println(i);
                break;
            }
        }

    }
    private static int sol(int num){
        int res = 0;
        while(num > 0){
            int r = num % 10;
            res += (int) Math.pow(r,P);
            num /= 10;
        }
        return res;
    }
}