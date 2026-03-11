import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    static String str;
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       str =br.readLine();
       int idx=0;
       int n =1;
       while(idx<str.length()){
           String numString = String.valueOf(n);
           for(int i =0; i<numString.length(); i++){
               if(numString.charAt(i) == str.charAt(idx)){
                   idx++;
                   if(idx==str.length()) break;
               }
           }
           n++;
       }
       System.out.println(n-1);


   }
}