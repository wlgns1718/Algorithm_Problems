import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static boolean[] selected;
	static ArrayList<String> arr = new ArrayList<String>();
	static int L,C, cnt;
	static String temp;
	static String[] temp_string;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		selected = new boolean[C];
		temp_string = new String[L];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i< C; i++) {
			arr.add(st.nextToken());
		}
		Collections.sort(arr);
		
		sol(0,0);
		
		
	}
	public static void sol(int idx,int start) {
		if (idx == L) {
			cnt = 0;
			temp ="";
			for(int j = 0; j<L; j++) {
				if(temp_string[j].equals("a") || temp_string[j].equals("e") || temp_string[j].equals("o") || temp_string[j].equals("i") || temp_string[j].equals("u")) {
					cnt ++;
				}
				temp += temp_string[j];
			}
			if(cnt >= 1 && L-cnt >= 2) {
				System.out.println(temp);
			}
			return;
		}
		for (int i = start; i<C; i++) {
			if(selected[i])continue;
			temp_string[idx] = arr.get(i);
			selected[i] = true;
			sol(idx +1,i+1);
			selected[i] = false;
		}
	}

}