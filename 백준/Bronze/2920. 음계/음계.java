import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[] pitch = new int[8];
	static boolean asc=true;
	static boolean desc=true;
	static boolean mix=true;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<8; i++) {
			pitch[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<7; i++) {
			if(pitch[i]>pitch[i+1]) {
				asc = false;
			}
			else if(pitch[i] < pitch[i+1]) {
				desc = false;
			}
			
		}
		if (asc) {
			System.out.println("ascending");
			
		}
		else if(desc) {
			System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
		
	}

}