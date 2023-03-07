import java.util.Scanner;

public class Main{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String text = sc.next();
		int temp = 6;
		String temp_str;
		String temp_ans;
		String[] answer = {"000000","001111","010011","011100","100110","101001","110101","111010"};
		String[] answer2 = {"A","B","C","D","E","F","G","H"};
		String[] sol = new String[n];
		int cnt = 0;
		int trigger = 0;
		int error =0;
		int trigger2 = 0;
		for(int i = 0; i<text.length(); i +=6 ) {
			trigger = 0;
			temp_str = text.substring(i,temp);
			for(int j=0; j<answer.length; j++) {//ABCDEFGH중에 있는지 비교
				if(answer[j].equals(temp_str)) {
					sol[cnt] = answer2[j];
					trigger = 1;
					cnt++;
					temp += 6;
					break;
				}
			}
			if(trigger==1) {
				continue;
			}
			//오타가 있는 경우
			int cnt2 =0;
			String [] can_case = new String [n];
			for(int tmp = 0; tmp <answer.length; tmp++) {
				error = 0;
				temp_ans = answer[tmp];
				for(int e=0; e<6; e++) {//몇글자가 틀렸는지 확인
					if(temp_ans.charAt(e) != temp_str.charAt(e)) {
						error +=1;
					}
				}
				if(error==1) {
					can_case[cnt2] = answer2[tmp];
					cnt2++;
				}
				else if(error>=2) {
					continue;
				}
			}
			if(cnt2>1 || cnt2 ==0) {//헷갈리는 글자가 2개이상, 헷갈리는 글자가 하나도 없을때
				System.out.println(cnt+1);
				trigger2 =1;
				break;
			}
			else {//헷갈리는 글자가 1개
				sol[cnt] = can_case[0];
				cnt++;
				temp += 6;
			}
			
		}
		if(trigger2 != 1) {
			for(int i=0; i<cnt; i++) {
				System.out.print(sol[i]);
			}
		}
		
		
		
		
		
		
     }
}
