import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {
	static int[][] sdoqu = new int[9][9];
	static int zero=0;
	static boolean tri;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String temp;
		for(int i = 0; i<9; i++) {
			temp = br.readLine();
			for(int j = 0; j<9; j++) {
				sdoqu[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
				if(sdoqu[i][j]==0) {
					zero+=1;
				}
			}

		}
		sol(sdoqu);
//		System.out.println("변환 후" + Arrays.deepToString(sdoqu));
		
	}
	public static void sol(int[][] temp) {
		//완성되면 sdoqu에 값 다 넣어주기
		if(check(temp)) {
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					sdoqu[i][j] = temp[i][j];
//					System.out.println("값 넣기"+ sdoqu[i][j]);
				}
			}
			String temp1;
			for(int i =0; i<9; i++) {
				temp1 = "";
				for(int j = 0; j<9; j++) {
					temp1 += String.valueOf(sdoqu[i][j]);
				}
				System.out.println(temp1);
			}
//			System.out.println("이제 그만");
//			System.out.println(Arrays.deepToString(sdoqu));
//			System.out.println(Arrays.deepToString(temp));
			tri = true;
			return;
		}

		//완성 안되는 조건return
		for(int i = 0; i<9; i++) {
			if (tri) {
				break;
			}
			for(int j = 0; j<9; j++) {
				if (tri) {
					break;
				}
				if(temp[i][j]!=0) {//숫자가 들어가 있는 상황이라면
					continue;
				}
				for(int num=1; num <= 9; num++) {//숫자 넣어주기
					if (tri) {
						break;
					}
					if(!check1(temp,i,j,num))continue;
					if(!check2(temp,i,j,num))continue;
					//들어갈 수 있는 수라면 재귀 호출
					temp[i][j] = num;
					sol(temp);
					temp[i][j] = 0;
					
				}
				if(temp[i][j]==0) {
					return;
				}

			}
		}
		//숫자 넣고 재귀 호출


	}
	public static boolean check(int[][] temp) {
		for(int i=0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if (temp[i][j]==0) {
					
					return false;
				}
			}
		}
//		System.out.println("0이 없다");
//		System.out.println(Arrays.deepToString(temp));
		return true;
	}
	public static boolean check1(int[][] temp,int x,int y, int number) {//행 열 체크
		for(int i = 0; i<9; i++) {
			if(i == y) continue;
			
			if(temp[x][i] == number) {
				return false;
			}
		}
		for(int i = 0; i<9; i++) {
			if(i == x) continue;
			if(temp[i][y] == number) {
				return false;
			}
		}
		return true;
	}

	public static boolean check2(int[][] temp,int x,int y, int number) {//칸 체크
		if(x<3) {
			if(y<3) {
				for(int i = 0; i < 3; i++) {
					for(int j=0; j<3; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
			else if(y<6) {
				for(int i = 0; i < 3; i++) {
					for(int j=3; j<6; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
			else {
				for(int i = 0; i < 3; i++) {
					for(int j=6; j<9; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
		}
		else if(x<6) {
			if(y<3) {
				for(int i = 3; i < 6; i++) {
					for(int j=0; j<3; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
			else if(y<6) {
				for(int i = 3; i < 6; i++) {
					for(int j=3; j<6; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
			else {
				for(int i = 3; i < 6; i++) {
					for(int j = 6; j<9; j++) {
						if(temp[i][j]==number) {
//							System.out.println(Arrays.deepToString(temp));
//							System.out.println("현재 좌표 "+ x+", "+y+"넣을려는 숫자는 :"+number);
							return false;
						}
					}
				}
			}
		}
		else {
			if(y<3) {
				for(int i = 6; i < 9; i++) {
					for(int j=0; j<3; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
			else if(y<6) {
				for(int i = 6; i < 9; i++) {
					for(int j=3; j<6; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
			else {
				for(int i = 6; i < 9; i++) {
					for(int j=6; j<9; j++) {
						if(temp[i][j]==number) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}