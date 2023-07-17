import java.util.*;
import java.io.*;

public class Main {
    static int K, M, sqrt,answer;
    static List<Integer> number = new LinkedList<>();
    static List<Integer> decimal = new LinkedList<>();
    static List<Integer> sum = new LinkedList<>();
    static List<Integer> product = new LinkedList<>();

    //소수
    static boolean[] prime = new boolean[98766];

    static boolean[] visited = new boolean[10];

    static int[] result;
    static HashSet<Integer> ans = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(prime,true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 자리수
        M = Integer.parseInt(st.nextToken()); // 최대 값

        // K자리 수
        result = new int[K];

        make(0);
        decimal();
        int size = number.size();
        for (Integer integer : number) {
            if (check(integer) && check2(integer)){
                answer += 1;
            }

        }
        System.out.println(answer);

//        sum();
//        product();
//        compare();
        // System.out.println(decimal);
        // System.out.println(sum);
        // System.out.println(product);
    }

    private static boolean check2(int num) {
        while(num % M == 0){
            num /= M;

        }
        int temp = (int) Math.sqrt((double) num);
        //num이 소수의 곱인지 판단
        for(int i = 2; i <= temp + 1; i++){
            if(num% i ==0){
                if(prime[i] && prime[num/i]){
                    return true;
                };
            }
        }
        return false;
    }


    public static boolean check(int num){
        int start = 2;
        num -= 2;
        while(start < num){
            if(!prime[start] || !prime[num]){
                start++;
                num--;
                continue;
            }
            return true;
        }
        return false;
    }
    public static void make(int cnt) {
        if (cnt == K) {
            StringBuilder sb = new StringBuilder();
            boolean[] check = new boolean[10];
            for (int i = 0; i < K; i++) {
                if (check[result[i]]) {
                    return;
                }
                check[result[i]] = true;
                sb.append(result[i]);
            }
            number.add(Integer.parseInt(sb.toString()));
            return;
        }

        if (cnt == 0) {
            for (int i = 1; i < 10; i++) {
                if (visited[i]) {
                    continue;
                }

                result[cnt] = i;
                visited[i] = true;
                make(cnt + 1);
                visited[i] = false;
                result[cnt] = 0;
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (visited[i]) {
                    continue;
                }

                result[cnt] = i;
                visited[i] = true;
                make(cnt + 1);
                visited[i] = false;
                result[cnt] = 0;
            }
        }
    }

    // K 자리 수 소수 생성
    public static void decimal() {
//        boolean status;
        int max = (int) Math.pow(10, K);

        // max 미만의 K자리 소수 판별
//        for (int i = 2; i < max; i++) {
//            status = false;
//            // 제곱근을 구하고 그 이하 숫자로 판별
//            sqrt = (int) Math.sqrt(i);
//
//            for (int j = 2; j <= sqrt; j++) {
//                if (i % j == 0) {
//                    status = true;
//                    break;
//                }
//            }
//
//            // 소수
//            if (!status) {
//                decimal.add(i);
//            }
//        }
        prime[2] = true;
        for(int i=2; i<=98765; i++){
            if(!prime[i]){
                continue;
            }
            for(int j = i+i; j <= 98765; j += i){
                prime[j] = false;
            }
        }
    }

    // 합
//    public static void sum() {
//        HashSet<Integer> set = new HashSet<>();
//        int len = decimal.size();
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                int one = decimal.get(i) + decimal.get(j);
//
//                if (set.contains(one)) {
//                    continue;
//                }
//
//                for (int k = 0; k < number.size(); k++) {
//                    if (number.get(k) == one) {
//                        set.add(one);
//                        break;
//                    }
//                    if (number.get(k) > one) {
//                        break;
//                    }
//                }
//            }
//        }
//        for (Integer e : set) {
//            sum.add(e);
//        }
//    }
//
//    // 곱
//    public static void product() {
//        HashSet<Integer> set = new HashSet<>();
//        int len = decimal.size();
//
//        for (int i = 0; i < number.size(); i++) {
//            int temp = number.get(i);
//
//            // System.out.println();
//            // System.out.println("시작 " + temp);
//            while (temp % M == 0) {
//                temp = temp / M;
//                // System.out.println("나눔 " + temp);
//            }
//
//            // System.out.println("완료 " + temp);
//
//
//            for (int j = 0; j < len; j++) {
//                for (int k = 0; k < len; k++) {
//                    int two = decimal.get(j) * decimal.get(k);
//                    if (temp == two) {
//                        // System.out.println("사용 " + temp);
//                        set.add(number.get(i));
//                        break;
//                    }
//                    if (temp < two) {
//                        break;
//                    }
//                }
//            }
//        }
//
//        for (Integer e : set) {
//            product.add(e);
//        }
//    }
//
//    // 비교
//    public static void compare() {
//        for (int j = 0; j < product.size(); j++) {
//            for (int i = 0; i < sum.size(); i++) {
//                if (sum.get(i) > product.get(j)) {
//                    break;
//                }
//
//                if (sum.get(i) == product.get(j)) {
//                    ans.add(sum.get(i));
//                    break;
//                }
//
//            }
//        }
//    }
}
    