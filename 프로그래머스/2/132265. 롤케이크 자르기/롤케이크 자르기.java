
class Solution {
    static int[] arr, brr;
    static int a, b;
    public int solution(int[] topping) {
        int answer = 0;
        arr = new int[10001];
        brr = new int[10001];
        a = 1;
        arr[topping[0]] ++;
        b = 0;
        
        for(int i = 1; i < topping.length; i++){
            int temp = topping[i];
            if(brr[temp] == 0) b++;
            brr[temp] ++;
        }
        for(int i = 1; i < topping.length; i++){
            int temp = topping[i];
            brr[temp] --;
            if(brr[temp] == 0) b --;
            if(arr[temp] == 0) a++;
            arr[temp] ++;
            if(a == b) answer ++;
            
        }
        return answer;
    }
}