import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;



public class Main {
	static String sol;
	static String order;
	static int N;
	static boolean tri,tri1;
	static Deque<Integer> deque = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		String temp;
		for(int tc=0; tc<TC; tc++) {
			tri = false;
			tri1 = true;
			deque.clear();

			order = br.readLine();
			N = Integer.parseInt(br.readLine());
			temp = br.readLine();
			number(temp);

			for(int od = 0; od<order.length(); od++) {
				if(order.charAt(od)=='R') {
					if(tri) {
						tri = false;
					}
					else {
						tri = true;
					}
				}

				else {//tri 초기값은 false
					if(deque.isEmpty()) {
						bw.write("error\n");
						tri1=false;
						break;
					}
					if(!tri) {//처음 자리수 빼기
						deque.pollFirst();
					}
					else {//뒤에 자리수 빼기
						deque.pollLast();
					}
				}
			}
			if(!tri1)continue;
			//남은거 출력
			
			sol = print();
			bw.write(sol+"\n");
		}
		bw.close();


	}
	public static void number(String temp) {
		String temp1 = temp.substring(1, temp.length() - 1);
		String[] temp_list = temp1.split(",");
		if(!temp_list[0].equals("")) {
			for (int i = 0; i < temp_list.length; i++) {
				deque.add(Integer.parseInt(temp_list[i]));
			}

		}
	}

	public static String print() {
		StringBuilder answer=new StringBuilder();
		answer.append("[");
		while (!deque.isEmpty()) {
			if(tri) {//뒤에서 빼기
				answer.append(String.valueOf(deque.pollLast()) +",");
			}
			else {//앞에서 빼기
				answer.append(String.valueOf(deque.pollFirst()) +",");
			}
		}
		if(answer.charAt(answer.length()-1)==',') {
			answer.deleteCharAt(answer.length()-1);
		}
		answer.append("]");
		return answer.toString();
	}

}