import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TooManyListenersException;

class Main {
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> stack_idx = new Stack<>();
	static int[] arr;
	static int[] answer;
	static int idx;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		idx = N-1;
		arr = new int[N];
		answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=N-1; i>=0; i--) {
			if(stack.isEmpty()) {
				stack.add(arr[i]);
				stack_idx.add(i);
				continue;
			}
			
			if(stack.peek()>arr[i]) {
				stack.add(arr[i]);
				stack_idx.add(i);
			}
			
			else {
				while(stack.peek() <= arr[i]) {
					stack.pop();
					answer[stack_idx.pop()] = i+1;
					if(stack.isEmpty()) break;
				}
				stack.add(arr[i]);
				stack_idx.add(i);
			}
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
			answer[stack_idx.pop()] = 0;
		}
		for(int i=0; i<N; i++) {
			bw.write(answer[i]+" ");
		}
		bw.close();
		
	}
	

}