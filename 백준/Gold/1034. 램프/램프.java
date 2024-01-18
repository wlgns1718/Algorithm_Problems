import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[];
    static HashMap<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        String[] brr = new String[N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            brr[i] = temp;
            int cnt = 0;
            for(int j = 0; j < M; j++){
                if(temp.charAt(j) == '0'){
                    cnt++;
                }
            }
            arr[i] = cnt;
        }
        int k = Integer.parseInt(br.readLine());
        boolean tri = k % 2 == 0;
        int answer = 0;
        for(int i = 0; i < N; i++){
            if(arr[i] > k) continue;
            if(tri){
                if(arr[i] % 2 == 0){

                    if(!map.containsKey(brr[i])){
                        map.put(brr[i],0);
                    }
                    int a = map.get(brr[i]);
                    map.replace(brr[i], a + 1);
                }
            }
            else{
                if(arr[i] % 2 != 0){
                    if(!map.containsKey(brr[i])){
                        map.put(brr[i],0);
                    }
                    int a = map.get(brr[i]);
                    map.replace(brr[i], a + 1);
                }
            }
        }
        for(Integer temp : map.values()){
            if(answer < temp){
                answer = temp;
            }
        }
        System.out.println(answer);
    }
}