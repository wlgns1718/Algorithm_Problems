import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
public class Main {

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		BigInteger bigCnt = new BigInteger("2");
		bigCnt = bigCnt.pow(N);
		bigCnt= bigCnt.subtract(new BigInteger("1"));
		if(N>20) {
			System.out.println(bigCnt);
		}
		else {
			
			System.out.println(bigCnt);
			m1(N,1,2,3);
		}
		bw.close();
		
		
	}
	public static void m1(int N, int start, int mid, int to) throws Exception{
		
		if(N==1) {
			bw.write(start + " " + to+"\n");
			return;
			
		}
		m1(N-1, start, to, mid);
		
		bw.write(start + " " + to + "\n");
		
		m1(N-1,mid,start,to);

		
	}
}
