import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    static int[] arr;
    static int s;
    static int num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        arr = new int[T];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx< T; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());

        }//스위치 배열 완성


        int student = Integer.parseInt(br.readLine());
        for(int i = 1; i<= student; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());
            if(s == 1) {//남자인 경우
                for(int man = (num-1); man<T; man += num) {
                    if(arr[man]==1) {
                        arr[man] = 0;
                    }
                    else {
                        arr[man] = 1;
                    }
                }
            }
            else {//여자인 경우
                int woman = 0;
                while(true) {
                    if((num-1)+woman>=T | (num-1)-woman<0){
                        woman--;
                        break;
                    }
                    if(arr[num-1+woman] != arr[num-1-woman]){ woman --; break;}
                    else woman++;
                }
                for(int temp = num-1-woman; temp<=num+woman-1; temp++) {

                    if(arr[temp]==0) {
                        arr[temp]=1;
                    }else {
                        arr[temp] = 0;
                    }
                }
            }


        }
        for(int temp1 = 0; temp1<T; temp1++) {
            
            if (temp1 == 19 | temp1 == 39 | temp1 == 59 | temp1 == 79) {
                bw.write(arr[temp1]+" ");
                bw.write("\n");
            }
            else{
                bw.write(arr[temp1] + " ");
            }

        }bw.close();

    }

}