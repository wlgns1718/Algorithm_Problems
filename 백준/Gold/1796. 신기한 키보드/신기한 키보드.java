import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //왼쪽, 오른쪽, 엔터키
        //문자열이 쓰여져 있고 커서는 맨 왼쪽, LCD창은 문자열 S의 크기와 같다. 엔터를 누르면 빈칸이 되고 전송
        String word = st.nextToken();
        int word_len = word.length();
        int[][] dp = new int[26][word_len];
        for(int i = 0; i < 26; i++){
            Arrays.fill(dp[i],987654);
        }
        //a는 97 z는 122
        int last_char = 0;
        int[] min_idx = new int[26];
        int[] max_idx = new int[26];
        Arrays.fill(min_idx,100);
        boolean[] contain = new boolean[26];

        for(int i = 0; i < 26; i++){
            if(!word.contains(String.valueOf((char) (97 + i)))) continue;

            contain[i] = true;
            for(int j = 0; j < word_len; j++){
                if(word.charAt(j) == (char) (97 + i)){
                    min_idx[i] = Math.min(min_idx[i],j);
                    max_idx[i] = Math.max(max_idx[i],j);
                }

            }
        }
//        System.out.println("들어있는 알파벳 목록");
//        System.out.println(Arrays.toString(contain));
        boolean tri = false;
        for(int i = 0; i <= 25; i++){
            if(tri && !contain[i]){
                for(int j = 0; j < word_len; j++){
                    dp[i][j] = dp[i-1][j];
                }
                continue; //문자열이 포함되지 않는다면 패스
            }
            if(!contain[i]) continue;
            last_char = i;
            if(!tri){ //a일 때
                for(int j = 0; j < word_len; j++){
                    dp[i][j] = dist(0,j,min_idx[i],max_idx[i]);
                }
                tri = true;
            }
            else{
                for(int j = 0; j < word_len; j++){ //j는 끝나는 인덱스
                    for(int idx = 0; idx < word_len; idx++){ //idx는 시작 인덱스
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][idx] + dist(idx,j,min_idx[i],max_idx[i]));
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(dp[0]));
//        System.out.println(Arrays.toString(dp[last_char]));
//        System.out.println(max_idx[1]+" "+min_idx[1]);
        int answer = 987654321;
        for(int i = 0; i < word_len; i++){
            answer = Math.min(answer,dp[last_char][i]);
        }
        answer += word_len;
        System.out.println(answer);

    }
    public static int dist(int cur_idx, int arr_idx, int min_idx, int max_idx ){
        int val = Math.min(Math.abs(cur_idx - min_idx) + Math.abs(min_idx-max_idx) + Math.abs(max_idx-arr_idx),
                Math.abs(cur_idx - max_idx) + Math.abs(max_idx-min_idx) + Math.abs(min_idx-arr_idx));
        return val;
    }

}