import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       while(true){
           String str = br.readLine();
           if(str.equals("*")) break;

           if(isSuprise(str)) sb.append(str).append(" is surprising.").append("\n");
           else sb.append(str).append(" is NOT surprising.").append("\n");
       }
       System.out.println(sb);
   }
   public static boolean isSuprise(String str){

        for(int i =0; i<str.length()-1; i++){
            HashMap<String ,Integer> map = new HashMap<>();
            for(int j=0; j<str.length(); j++){
                int last = j+i+1;
                if(last==str.length())break;

                String temp =""+ str.charAt(j) + str.charAt(last);
                map.put(temp,map.getOrDefault(temp,0)+1);
                if(map.get(temp)>1) return false;
            }
        }

        return true;
   }
}