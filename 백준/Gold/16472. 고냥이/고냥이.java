import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static PriorityQueue<String> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();;
        int answer = 0;
        int idx = 0;
        int temp = 0;
        int[] alp = new int[26];
        int cnt = 0;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(cnt < N){
                if(alp[(int) ch - (int)'a'] == 0){
                    cnt++;
                }
                alp[(int) ch - (int)'a']++;
                temp++;

            }
            else{
                if(alp[(int) ch - (int)'a'] != 0){
                    alp[(int)ch - (int)'a']++;
                    temp++;
                }
                else{
                    //현재 문자가 포함되지 않을 때
                    if(answer < temp){
//                        System.out.println(Arrays.toString(alp));
                        answer = temp;
                    }
                    while(idx < word.length() && cnt == N ){
                        alp[(int) word.charAt(idx) - (int)'a']--;
                        temp--;
                        if(alp[(int) word.charAt(idx) - (int)'a'] == 0){
                            cnt--;
                        }
                        idx++;
                    }
                    alp[(int)ch  - (int)'a']++;
                    temp++;
                    cnt++;

                }

            }
        }
        if(answer < temp){
            answer = temp;
        }

        System.out.println(answer);
    }



}