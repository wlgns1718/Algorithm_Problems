import java.io.*;
import java.math.BigInteger;
class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        BigInteger ori = new BigInteger(input);
        BigInteger pal;

        if(input.length() == 1){
            int temp = Integer.parseInt(input);
            if(temp == 9){
                System.out.println(11);
                return;
            }
            else{
                System.out.println(temp + 1);
                return;
            }
        }

        if(input.length() % 2 == 0){
            //길이가 짝수 일 때
            sb.append(input, 0, input.length()/2);

            pal = new BigInteger(sb.toString() + sb.reverse());
            if(check(ori, pal)){
                System.out.println(pal);
            }
            else{

                BigInteger answer;
                sb.reverse();
                pal = new BigInteger(sb.toString());

                answer = pal.add(new BigInteger("1"));
                sb.delete(0, sb.length());
                sb.append(answer);
                if(sb.length() * 2 > input.length() + 1){
                    answer = new BigInteger(sb.toString() + sb.reverse().substring(1));
                    System.out.println(answer);
                }
                else{
                    answer = new BigInteger(sb.toString() + sb.reverse().toString());
                    System.out.println(answer);
                }

            }
        }
        else{
            sb.append(input.substring(0, input.length()/2 + 1));
            pal = new BigInteger(sb.toString() + sb.reverse().substring(1));
            sb.reverse();

            if(check(ori, pal)){
                System.out.println(pal);
            }
            else{
                BigInteger answer;
                pal = new BigInteger(sb.toString());
                answer = pal.add(new BigInteger("1"));
                sb.delete(0, sb.length());
                sb.append(answer);
                if(sb.length() * 2 - 1 > input.length() + 1){
                    answer = new BigInteger(sb.toString() + sb.reverse().substring(2));
                    System.out.println(answer);
                }
                else{
                    answer = new BigInteger(sb.toString() + sb.reverse().substring(1));
                    System.out.println(answer);
                }
            }
        }


    }
    private static boolean check(BigInteger ori, BigInteger pal){
        if(ori.compareTo(pal) < 0){
            return true;
        }
        else{
            return false;
        }
    }
}