import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> q = new Stack<>();

        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                q.pop();
            }
            else{
                q.add(a);
            }
        }
        int answer = 0;
        while(!q.isEmpty()){
            answer += q.pop();
        }
        System.out.println(answer);
    }
}