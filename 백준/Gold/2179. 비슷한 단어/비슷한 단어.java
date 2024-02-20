import java.io.*;
import java.util.*;

public class Main {
    static List<String> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            for(int i=0;i<n;i++) {
                String str = br.readLine();
                if(!arr.contains(str)) {
                    arr.add(str);
                }
            }
            int a = 0;
            int b = 0;
            int max = 0;
            for(int i=0;i<n-1;i++) {
                String str1 = arr.get(i);
                for(int j=i+1;j<n;j++) {
                    String str2 = arr.get(j);
                    int count = 0;
                    int len = Math.min(str1.length(), str2.length());
                    for(int k=0;k<len;k++) {
                        if(str1.charAt(k)!=str2.charAt(k)) {
                            break;
                        }
                        count++;
                    }
                    if(max<count) {
                        max = count;
                        a = i;
                        b = j;
                    }
                }
            }
            System.out.println(arr.get(a));
            System.out.println(arr.get(b));
    }
}