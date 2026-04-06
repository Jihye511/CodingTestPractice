import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       HashSet<String> set = new HashSet<>();
       for(int i =0; i<N; i++){
           String word = br.readLine();
           set.add(word);
       }
       for(int i =0; i<M; i++){
           String[] input = br.readLine().split(",");
           for(String str : input){
               if(set.contains(str)){
                   set.remove(str);
               }
           }
           sb.append(set.size()).append("\n");
       }
       System.out.println(sb);
   }
}