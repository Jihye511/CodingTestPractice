import java.io.*;
import java.util.*;
public class Main{
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n, m;
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      int cnt = 0;
      Set<String> set = new HashSet<>();
      for(int i =0; i<n; i++){
         set.add(br.readLine());
      }
      for(int i =0; i<m; i++){
         if(set.contains(br.readLine())) cnt ++;
      }


      System.out.println(cnt);
   }
}