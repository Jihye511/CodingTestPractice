import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("end"))break;

            if(checkFirst(str) && checkSecond(str) && checkThird(str)){
                sb.append("<").append(str).append("> is acceptable.\n");
            } else {
                sb.append("<").append(str).append("> is not acceptable.\n");
            }
        }
        System.out.println(sb);
    }
    public static boolean checkFirst(String str){
        char[] ch = str.toCharArray();
        int cnt=0;
        for(char i : ch){
            if(i =='a' || i =='e' || i=='i' || i=='o' || i=='u') cnt++;
        }
        if(cnt >0) return true;
        else return false;
    }
    public static boolean checkSecond(String str){
        int vowel = 0;
        int consonant = 0;

        for(char c : str.toCharArray()){
            if("aeiou".indexOf(c) >= 0){
                vowel++;
                consonant = 0;
            } else {
                consonant++;
                vowel = 0;
            }

            if(vowel == 3 || consonant == 3)
                return false;
        }

        return true;
    }
    public static boolean checkThird(String str){
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i-1)){
                if(str.charAt(i) != 'e' && str.charAt(i) != 'o')
                    return false;
            }
        }
        return true;
    }
}