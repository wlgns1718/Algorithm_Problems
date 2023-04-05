import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,d,k,c;
    static int[] chobab,jeopsi;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int answer = 0,cnt =0,index = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//초밥 벨트에 놓인 접시의 수
        d = Integer.parseInt(st.nextToken());//초밥의 가짓수
        k = Integer.parseInt(st.nextToken());//연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken());//쿠폰 번호
        
        chobab = new int[d+1];
        jeopsi = new int[N];
        for(int i=0; i<N; i++) {
        	jeopsi[i] = Integer.parseInt(br.readLine());
        }
        //k만큼 먹기
        int temp;
        for(int i = 0; i<k; i++) {
        	temp = jeopsi[index++];
        	
        	queue.offer(temp);
        	if(chobab[temp]==0) {
        		cnt++;
        	}
        	chobab[temp]++;
        }

        answer = cnt;
        
        if(chobab[c]==0) {
        	answer++;
        }
        
        for(int i=0; i<N; i++) {
        	if(index == N) {
        		index = 0;
        	}
        	temp = queue.poll();
        	if(chobab[temp]==1) {
        		cnt--;
        	}
        	chobab[temp]--;
        	temp = jeopsi[index++];
        	queue.offer(temp);
        	if(chobab[temp]==0) {
        		cnt++;
        	}
        	chobab[temp]++;
        	
        	if(chobab[c]==0) {
        		if(answer < cnt+1) {
        			answer = cnt+1;
        		}
        	}
        	else {
        		if(answer < cnt) {
        			answer = cnt;
        		}
        	}
        	
        }

        
        System.out.println(answer);

    }

}