import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int T = Integer.parseInt(br.readLine());
       for(int t =0; t<T; t++){
           int N = Integer.parseInt(br.readLine());
           StringTokenizer st = new StringTokenizer(br.readLine());
           int[] money= new int[N];

           for(int i =0; i<N; i++){
               money[i] = Integer.parseInt(st.nextToken());
           }
           long sum=0;
           int max = money[N-1];
           for(int i=N-2; i>=0; i--){
               if(money[i]<=max){
                   sum += max - money[i];
               }else{
                   max = money[i];
               }
           }
           sb.append(sum).append("\n");
       }
       System.out.println(sb);
   }
}