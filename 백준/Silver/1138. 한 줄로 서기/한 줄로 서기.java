import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       StringTokenizer st = new StringTokenizer(br.readLine());
       int[] line = new int[N];
       for(int i =0; i<N; i++){
           line[i] = Integer.parseInt(st.nextToken());
       }
       int[] ans =new int[N];
       for(int idx = 0; idx<N; idx++){
           int cur = line[idx];
           int i =0;
           while(true){
               if(cur==0){
                   if(ans[i]==0) {
                       ans[i] =idx+1;
                       break;
                   }
               }else if(ans[i]==0) cur--;
               i++;
           }
       }
       for( int i : ans){
           sb.append(i).append(" ");
       }
       System.out.println(sb);
   }
}