import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String word = br.readLine();
        sb.append(":fan::fan::fan:").append("\n").append(":fan::").append(word).append("::fan:").append("\n")
                .append(":fan::fan::fan:");
        System.out.println(sb);
    }

}