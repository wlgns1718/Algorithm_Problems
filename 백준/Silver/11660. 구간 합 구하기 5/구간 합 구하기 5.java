import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
    static int N,M,x1,x2,y1,y2,sum;
    static int[][] map;
    static int[][] new_map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        new_map = new int[N][N];
        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==0 & j ==0) {
                    new_map[i][j] = map[i][j];
                    continue;
                }
                else if( i==0 ){
                    new_map[i][j] = map[i][j]+new_map[i][j-1];
                }
                else if( j==0 ){
                    new_map[i][j] = map[i][j]+new_map[i-1][j];
                }
                else {
                    new_map[i][j] = map[i][j] + new_map[i-1][j] + new_map[i][j-1] - new_map[i-1][j-1];
                }
            }
        }
        for(int i = 0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) - 1;
            y1 = Integer.parseInt(st.nextToken()) - 1;
            x2 = Integer.parseInt(st.nextToken()) - 1;
            y2 = Integer.parseInt(st.nextToken()) - 1;
            if(x1==0 & y1 ==0){
                sum = new_map[x2][y2];

            }else if(x1 ==0){
                sum = new_map[x2][y2] - new_map[x2][y1-1];
            }else if(y1 == 0){
                sum = new_map[x2][y2] - new_map[x1-1][y2];
            }
            else{
                sum = new_map[x2][y2] - new_map[x1-1][y2] - new_map[x2][y1-1]+new_map[x1-1][y1-1];
            }
            bw.write(sum + "\n");
            
        }
        bw.close();


    }

}