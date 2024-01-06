import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        tree = new int[n];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i = 0; i < n; i++){

            int temp = Integer.parseInt(st.nextToken());
            tree[i] = temp;
            sum += temp;
        }

        if(sum % 3 != 0){
            System.out.println("NO");
        }
        else{
            int mot = sum / 3; //2와 1 사용해야할 개수
            int cnt = 0;

            //2를 사용할 수 있을 만큼 사용하기
            for(int i = 0; i < n; i++){
                if(tree[i] >= 2){
                    // mot을 넘지 않는지 확인
                    if((cnt + tree[i] / 2) <= mot){
                        int temp_mot = tree[i]/2;
                        cnt += temp_mot;
                        tree[i] -= (temp_mot * 2);
                    }
                    else{ // mot을 넘긴다면
                        // mot 만큼 채우기
                        int temp_mot = mot-cnt;
                        cnt += temp_mot;
                        tree[i] -= (temp_mot * 2);
                        break;
                    }
                }
            }
//            System.out.println(Arrays.toString(tree));
            if(cnt != mot){
                System.out.println("NO");
            }
            else{
                int sum_remain = 0;
                for(int num : tree){
                    sum_remain += num;
                }
                if(sum_remain == mot){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
        }
    }
}