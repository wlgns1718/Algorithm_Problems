import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,point[],p,q;
	static int answer = 0;
	static boolean tri;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		point = new int[n];
		
		for(int i = 0; i<n; i++) {
			point[i]=i;
		}
		
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			if(!unionset(p,q)) {
				answer ++;
				tri = true;
				break;
			}
			answer++;
			
		}
		if (tri) {
			System.out.println(answer);
		}
		else {
			System.out.println(0);
		}
	}
	
	public static boolean unionset(int a,int b) {
		a = findset(a);
		b = findset(b);
		if(point[b]==a) {
			return false;
		}
		else {
			point[b] = a;
			return true;
		}
		
		
		
	}
	public static int findset(int x) {
		if(point[x]==x) {
			return x;
		}
		return point[x]=findset(point[x]);
		
	}

}