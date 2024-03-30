import java.util.*;
import java.io.*;


public class Main {
    static int N, ans1, ans2;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] fun1 = {5,
            8,
            13,
            21,
            34,
            55,
            89,
            144,
            233,
            377,
            610,
            987,
            1597,
            2584,
            4181,
            6765,
            10946,
            17711,
            28657,
            46368,
            75025,
            121393,
            196418,
            317811,
            514229,
            832040,
            1346269,
            2178309,
            3524578,
            5702887,
            9227465,
            14930352,
            24157817,
            39088169,
            63245986,
            102334155};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(fun1[N-5]).append(" ").append(N-2);
        System.out.println(sb);
    }
}