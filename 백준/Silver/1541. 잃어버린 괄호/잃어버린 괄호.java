import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp = br.readLine();
		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<String> oper = new ArrayList<>();
		int start = 0;
		for(int i = 0; i < temp.length(); i++) {
			if(i==temp.length()-1) {
				nums.add(Integer.parseInt(temp.substring(start,i+1)));
				break;
			}
			if (temp.charAt(i) == '+') {
				oper.add("+");
				String t = temp.substring(start,i);
				nums.add(Integer.parseInt(t));
				start = i+1;
			}
			else if(temp.charAt(i)=='-') {
				oper.add("-");
				String t = temp.substring(start,i);
				nums.add(Integer.parseInt(t));
				start = i+1;
			}
		}
		
		int minus = Integer.MAX_VALUE;
		
		for(int i = 0; i < oper.size(); i++) {
			if(oper.get(i).equals("-")) {
				minus = i;
				break;
			}
			
		}
		int answer = 0;
		for(int i =0; i<nums.size(); i++) {
			if(i <= minus) {
				answer += nums.get(i);
			}
			else {
				answer -= nums.get(i);
			}
		}
		System.out.println(answer);
		
	
	}

}