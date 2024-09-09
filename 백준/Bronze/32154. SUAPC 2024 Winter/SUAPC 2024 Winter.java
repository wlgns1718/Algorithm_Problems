import java.io.*;
import java.util.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        switch (N){
            case 1:
                sb.append(11).append("\n").append("A B C D E F G H J L M");
                break;
            case 2:
                sb.append(9).append("\n").append("A C E F G H I L M");
                break;
            case 3:
                sb.append(9).append("\n").append("A C E F G H I L M");
                break;
            case 4:
                sb.append(9).append("\n").append("A B C E F G H L M");
                break;
            case 5:
                sb.append(8).append("\n").append("A C E F G H L M");
                break;
            case 6:
                sb.append(8).append("\n").append("A C E F G H L M");
                break;
            case 7:
                sb.append(8).append("\n").append("A C E F G H L M");
                break;
            case 8:
                sb.append(8).append("\n").append("A C E F G H L M");
                break;
            case 9:
                sb.append(8).append("\n").append("A C E F G H L M");
                break;
            case 10:
                sb.append(8).append("\n").append("A B C F G H L M");
                break;
        }
        System.out.println(sb);
    }

}