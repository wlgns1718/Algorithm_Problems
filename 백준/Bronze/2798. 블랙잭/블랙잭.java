import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static int[] cards;
	static int[] brr = new int[3];
	static int sum;
	static int Max_NUM = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //카드 수
		M = Integer.parseInt(st.nextToken()); //목표 합
		
		cards = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		m1(0,0,M);
		bw.write(Max_NUM+"");
		bw.close();
		
		
		
		
	}
	
	public static void m1(int idx, int start, int M) {
		if(idx==3) {
			sum = 0;
			for(int i =0; i<3; i++) {
				sum+= brr[i];
			}if(M<sum) {
				return;
			}
			else if(sum>Max_NUM) {
				Max_NUM = sum;
			}
			return;
		}
		for(int temp=start; temp<N; temp++) {
			brr[idx] = cards[temp];
			m1(idx + 1, temp+1,M);
		}
		
		
	}
}