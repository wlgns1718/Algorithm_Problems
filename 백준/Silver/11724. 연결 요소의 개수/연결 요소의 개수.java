import java.io.*;
import java.util.*;

public class Main {

    static int[] ls;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        ls = new int[N+1];
        for(int i = 0; i <= N; i++){
            ls[i] = i;
        }
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            setNode(a, b);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++){
            set.add(find(i));
        }
//        System.out.println(Arrays.toString(ls));
        System.out.println(set.size());
    }
    private static int find(int val){
        if(ls[val] == val){
            return val;
        }
        return ls[val] = find(ls[val]);
    }
    private static void setNode(int a, int b){

        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        int findA = find(a);
        int findB = find(b);
        ls[findB] = findA;
    }
}