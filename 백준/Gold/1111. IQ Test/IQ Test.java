import java.util.*;
import java.io.*;


public class Main {
    static int N,arr[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N == 1 || (N == 2 && arr[0] != arr[1])){ // 무조건 해가 많을 때
            System.out.println("A");
        }
        else if(N == 2){ //a = 1, b = 0일 때
            System.out.println(arr[0]);
        }
        else{
            int a, b;
            if(arr[1] == arr[0]){
                a = 1;
                b = 0;
            }
            else{
                a = (arr[2]-arr[1])/(arr[1]-arr[0]);
                b = arr[1] - (arr[0] * a);
            }
            if(sol(a,b)){
                System.out.println(arr[N-1]*a + b);
            }
            else{
                System.out.println("B");
            }

        }
    }
    private static boolean sol(int a, int b){
        //a,b 로 모든 수열 조건 만족하는지 체크
        for(int i = 0; i < N - 1; i++){
            if(arr[i+1] != (arr[i]*a + b)) return false;

        }
        return true;
    }

}