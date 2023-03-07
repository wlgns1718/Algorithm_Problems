import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TooManyListenersException;

class Main {
	static String[] arr;
	static boolean tri = true;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for(int i = 0 ; i<N; i++) {
			arr[i] = br.readLine();
		}
		int length = arr[0].length();
		
		int idx = 1;
		while (true) {
			map.clear();
			if(idx==length) {
				break;
			}
			for(int i = 0; i<N; i++) {
				if(map.containsKey(arr[i].substring(length-idx, length))){
					idx++;
					break;
				}
				else map.put(arr[i].substring(length-idx,length), 1);
			}
			if(map.size()==N) {
				break;
			}
			
		}
		System.out.println(idx);
		
		
	}
	

}