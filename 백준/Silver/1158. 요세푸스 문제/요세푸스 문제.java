import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TooManyListenersException;

class Main {
	
	static int N,K,idx;
	static int[] answer;
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = new int[N];
		for(int i =1; i<=N; i++) {
			list.add(i);
		}
		idx = K-1;
		for(int i =0; i<N; i++) {
			while(idx >= list.size()) {
				idx -= list.size();
			}
			answer[i] = list.get(idx);
			list.remove(idx);
			idx -= 1;
			idx += K;
		}
		bw.write("<");
		for(int i = 0; i<answer.length; i++) {
			if(i== answer.length-1) {
				bw.write(answer[i]+"");
				break;
			}
			bw.write(answer[i]+", ");
		}
		bw.write(">");
		bw.close();
	}
	

}