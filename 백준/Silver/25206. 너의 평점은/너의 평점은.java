import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        double sum = 0.0;
        double subject = 0.0;
        for(int i = 0; i < 20; i++){
            input = br.readLine().split(" ");
            float point = Float.parseFloat(input[1]);
            String degree = input[2];
            if(degree.equals("A+")){
                sum += point * 4.5;
                subject += point;
            }
            else if(degree.equals("A0")){
                sum += point * 4.0;
                subject += point;
            }
            else if(degree.equals("B+")){
                sum += point * 3.5;
                subject += point;
            }
            else if(degree.equals("B0")){
                sum += point * 3.0;
                subject += point;
            }
            else if(degree.equals("C+")){
                sum += point * 2.5;
                subject += point;
            }
            else if(degree.equals("C0")){
                sum += point * 2.0;
                subject += point;
            }
            else if(degree.equals("D+")){
                sum += point * 1.5;
                subject += point;
            }else if(degree.equals("D0")){
                sum += point;
                subject += point;
            }
            else if(degree.equals("F")){
                subject += point;
            }
            
        }
        System.out.printf("%.6f", sum/subject);
    }

}