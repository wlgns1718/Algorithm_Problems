import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] numbers;

	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			if(i==0) {
				numbers[i] = Integer.parseInt(st.nextToken());
			continue;
			}
			numbers[i] = (Integer.parseInt(st.nextToken())) + numbers[i-1];
			
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = (Integer.parseInt(st.nextToken())) - 1;
			int end = (Integer.parseInt(st.nextToken())) - 1;
			if(start == 0) {
				bw.write(numbers[end]+"\n");
			}
			else {
				bw.write(numbers[end]-numbers[start-1]+"\n");
			}
		}
				
		bw.close();
		
	}
}