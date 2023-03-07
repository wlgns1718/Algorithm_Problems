import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int S, P;
	static String dna;
	static int[] ACGT = new int[4];
	static int[] temp = {0,0,0,0};
	static int answer = 0;
	static boolean tri = true;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // 임의로 만든 문자열 길이
		P = Integer.parseInt(st.nextToken());// 사용할 문자열 길이

		dna = br.readLine();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		} // ACGT 몇번 포함되어야 하는지 배열
		int idx = 1;
		int end = P - 1;
		for(int i = 0; i<=end; i++) {
			if (dna.charAt(i)=='A') {
				temp[0]+=1;
			}
			else if (dna.charAt(i)=='C') {
				temp[1]+=1;
			}
			else if (dna.charAt(i)=='G') {
				temp[2]+=1;
			}
			else if (dna.charAt(i)=='T') {
				temp[3]+=1;
			}
		}
		for(int i = 0; i<4; i++) {
			if(ACGT[i]>temp[i]) {
				tri = false;
				break;
			}
		}
		if(tri) {
			answer += 1;
		}
		//맨 처음 문자열 갯수 확인 
		while (end + idx < S) {
			tri = true;
			if (dna.charAt(idx-1) == 'A') {
				temp[0] -=1;
			}
			else if (dna.charAt(idx-1) == 'C') {
				temp[1] -=1;
			}
			else if (dna.charAt(idx-1) == 'G') {
				temp[2] -=1;
			}
			else if (dna.charAt(idx-1) == 'T') {
				temp[3] -=1;
			}
			
			if(dna.charAt(end+idx)=='A') {
				temp[0] += 1;
			}
			else if(dna.charAt(end+idx)=='C') {
				temp[1] += 1;
			}
			else if(dna.charAt(end+idx)=='G') {
				temp[2] += 1;
			}
			else if(dna.charAt(end+idx)=='T') {
				temp[3] += 1;
			}
			
			for(int i= 0; i<4; i++) {
				if(ACGT[i]>temp[i]) {
					tri = false;
					break;
				}
			}
			if(tri) {
				answer += 1;
			}
			idx++;
		}
		System.out.println(answer);
	}

}
