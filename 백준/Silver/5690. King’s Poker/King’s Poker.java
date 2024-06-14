import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        int[] arr = new int[3];
        int[] brr = new int[3];
        while(true){

            input = br.readLine().split(" ");
            for(int i = 0; i < 3; i++){
                arr[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(arr);
            if(arr[0] == 12 && arr[1] == 13 && arr[2] == 13){
                sb.append("1 1 1").append("\n");
                continue;
            }
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
            if(arr[0] == arr[1] && arr[1] == arr[2]){
                if(arr[0] == 13){
                    sb.append("*").append("\n");
                    continue;
                }
                else{
                    brr[0] = arr[0] + 1;
                    brr[1] = arr[0] + 1;
                    brr[2] = arr[0] + 1;
                }
            }
            else if(arr[0] == arr[1] || arr[1] == arr[2]){
                int temp;
                if(arr[0] == arr[1]) temp = arr[2];
                else temp = arr[0];
                if(temp == 13){
                    brr[0] = 1;
                    brr[1] = arr[1] + 1;
                    brr[2] = arr[1] + 1;
                }
                else{
                    if(temp + 1 == arr[1]){
                        brr[0] = temp + 2;
                        brr[1] = arr[1];
                        brr[2] = arr[1];
                    }
                    else{
                        brr[0] = temp + 1;
                        brr[1] = arr[1];
                        brr[2] = arr[1];
                    }
                }
            }
            else{
                sb.append("1 1 2").append("\n");
                continue;
            }
            Arrays.sort(brr);
            sb.append(brr[0]).append(" ").append(brr[1]).append(" ").append(brr[2]).append("\n");
        }
        System.out.println(sb);
    }
}