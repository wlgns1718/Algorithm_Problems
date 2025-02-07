import java.util.*;

class Solution {
    static List<List<Integer>> ls = new ArrayList<>();
    static boolean[] visit;
    static long res = 0;
    static long val = 0;
    static long[] arr;
    
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        long sum = 0;
        arr = new long[a.length];
        visit = new boolean[a.length];
        
        for (int j = 0; j < a.length; j++) {
            
            ls.add(new ArrayList<>());
            sum += a[j];
            arr[j] = a[j];
        }
        
        if(sum != 0){
            return -1;
        }
        
        int root = 0;
        int max_len = 0;
        for(int i = 0; i < edges.length; i++){
            
            int a1 = edges[i][0];
            int b = edges[i][1];
            ls.get(a1).add(b);
            ls.get(b).add(a1);
            
            if(max_len < ls.get(a1).size()){
                
                max_len = ls.get(a1).size();
                root = a1;
            }
            
            if(max_len < ls.get(b).size()){
                
                max_len = ls.get(b).size();
                root = b;
            }
        }
        visit[root] = true;
        
        sol(root, arr);
        answer = arr[root] == 0 ? res : -1;
        
        return answer;
    }
    private static void sol(int idx, long[] a){
        
        
        for(int i = 0; i < ls.get(idx).size(); i++){
            int temp = ls.get(idx).get(i);
            if(visit[temp]) continue;
            
            visit[temp] = true;
            sol(temp, a);
            
            val = a[temp];
            
            res += Math.abs(val);
            a[temp] -= val;
            a[idx] += val;
        }
    }
}