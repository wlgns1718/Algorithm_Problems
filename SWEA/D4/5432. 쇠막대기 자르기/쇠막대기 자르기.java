import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Solution {

    static String temp;
    static int idx, pipe,answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=TC; tc++){
            pipe=0;
            idx = 0;
            answer = 0;
            temp = br.readLine();
            for(int i=0; i<temp.length(); i++){
                if(temp.charAt(i)=='('){
                    idx+=1;
                }
                else{
                    if(temp.charAt(i-1)=='('){
                        idx-=1;
                        answer += idx;
                    }
                    else if(temp.charAt(i-1)==')'){
                        idx -=1;
                        pipe+=1;
                    }
                }
            }
            answer += pipe;
            System.out.printf("#%d %d%n",tc,answer);
        }
    }
}