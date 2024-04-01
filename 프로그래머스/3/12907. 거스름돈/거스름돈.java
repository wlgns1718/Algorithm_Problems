import java.util.*;

class Solution {
    static int arr[];
    static final int MOD = 1_000_000_007;
    public int solution(int n, int[] money) {
        int answer = 0;
        arr = new int[n+1];
        arr[0] = 1;
        for(int m : money){
            for(int i = m; i <= n; i++){
                arr[i] = (arr[i] + arr[i-m]) % MOD;
            }
        }
        // System.out.println(Arrays.toString(arr));
        return arr[n];
    }
}