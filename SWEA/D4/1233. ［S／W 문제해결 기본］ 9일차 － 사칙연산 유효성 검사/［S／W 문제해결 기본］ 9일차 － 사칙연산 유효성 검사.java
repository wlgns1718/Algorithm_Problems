import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	
	static int N;
	static boolean tri;
	static String a,b,c,d;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int tc = 1; tc<=10; tc++ ) {
			tri = true;
			N = Integer.parseInt(br.readLine());
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				if(!tri) continue;
				if(st.countTokens() ==4) {
					a = st.nextToken();
					b = st.nextToken();
					c = st.nextToken();
					d = st.nextToken();
					if(isInteger(b) || !isInteger(c) || !isInteger(d)) {
						tri = false;	
						continue;
					}
				}else {
					if(st.countTokens() !=2) {
						for(int te=0; te<st.countTokens(); te++) {
							a = st.nextToken();
						}
						tri = false;
						continue;
					}
					else {
						a = st.nextToken();
						b = st.nextToken();
						if(!isInteger(b)) {
							tri = false;
							continue;
						}
					}
				}
				
			}
			if(tri) {
				System.out.printf("#%d 1%n",tc);
			}else {
				System.out.printf("#%d 0%n",tc);
			}
			
		}
		
		
		
	}
	public static boolean isInteger(String strValue) {
	    try {
	      Integer.parseInt(strValue);
	      return true;
	    } catch (NumberFormatException ex) {
	      return false;
	    }
	  }

}