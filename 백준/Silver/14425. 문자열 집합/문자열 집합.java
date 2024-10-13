import java.io.*;
import java.util.*;
public class Main{
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n, m;
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      String[] S = new String[n];
      int cnt =0 ;

      for(int i=0; i<n; i++){
         S[i] = br.readLine();
      }
      for(int i =0; i<m; i++){
         String str = br.readLine();
         for(String sgroup : S){
            if(str.equals(sgroup)){
               cnt ++;
            }
         }
      }
      System.out.println(cnt);
   }
}