import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder temp  = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        boolean tagFlag = false;
        boolean spaceFlag = false;
        for(int i = 0; i < input.length(); i++){

            if(input.charAt(i) == '<'){
                tagFlag = true;
                if(temp.length() != 0){
                    answer.append(temp.reverse());
                    temp.delete(0, temp.length());

                }
                temp.append("<");
                continue;
            }
            if(input.charAt(i) == '>'){
                tagFlag = false;
                answer.append(temp).append(">");
                temp.delete(0, temp.length());
                continue;
            }
            if(tagFlag){
                temp.append(input.charAt(i));
                continue;
            }
            if(!spaceFlag && input.charAt(i) == ' '){
                spaceFlag = true;
                if(temp.length() != 0){
                    answer.append(temp.reverse());
                    temp.delete(0, temp.length());
                }
                answer.append(" ");
                continue;
            }
            if(spaceFlag && input.charAt(i) == ' '){
                spaceFlag = false;
                answer.append(temp.reverse()).append(" ");
                temp.delete(0, temp.length());
                continue;
            }

            if(spaceFlag){
                temp.append(input.charAt(i));
                continue;
            }
            temp.append(input.charAt(i));
        }
        if(temp.length() != 0){
            answer.append(temp.reverse());
        }
        System.out.println(answer);
    }

}