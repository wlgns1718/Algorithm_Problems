import java.util.*;
import java.io.*;


public class Main {
    static int N,M;
    static HashMap<String, List<String>> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String word, temp;
        for(int i = 0; i < N; i++){
            word = br.readLine();
            temp = sol(word);
            if(map.containsKey(temp)){
                map.get(temp).add(word);
            }
            else{
                map.put(temp, new ArrayList<>());
                map.get(temp).add(word);
            }

        }
        M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for(String i : input){
            temp = sol(i);
            Loop1:
            for(String words : map.get(temp)){
                if(words.length() == i.length()){
                    if(words.charAt(0) == i.charAt(0) && words.charAt(words.length()-1) == i.charAt(i.length()-1)){
                        sb.append(words).append(" ");
                        break Loop1;
                    }
                }
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
    private static String sol(String word){
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return String.copyValueOf(arr);
    }
}