import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       HashMap<String,Integer> map = new HashMap<>();
       String[] name = new String[N+1];
       for(int i =1; i<=N; i++){
           String str= br.readLine();
           name[i] = str;
           map.put(str,i);
       }
       for(int i = 0; i < M; i++){
           String input = br.readLine();
           if(!isNumber(input)){
               System.out.println(map.get(input));
           }else{
               int num = Integer.parseInt(input);
               System.out.println(name[num]);
           }
       }
   }
   public static boolean isNumber(String str){
       for(char c : str.toCharArray()){
           if(!Character.isDigit(c))return false;
       }
       return true;
   }
}