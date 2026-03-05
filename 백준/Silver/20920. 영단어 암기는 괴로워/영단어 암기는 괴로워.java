import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());

       HashMap<String, Integer> map = new HashMap<>();
       for(int i =0; i<N; i++){
           String str =br.readLine();
           if(str.length() <K) continue;
           map.put(str,map.getOrDefault(str,0)+1);
       }
       List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
       entryList.sort((o1,o2)-> {
                   if (!o1.getValue().equals(o2.getValue())) return o2.getValue() - o1.getValue();
                   if (o1.getKey().length() != o2.getKey().length()) return o2.getKey().length() - o1.getKey().length();
                   return o1.getKey().compareTo(o2.getKey());
               });
       StringBuilder sb = new StringBuilder();
       for(Map.Entry entry: entryList){
           sb.append(entry.getKey()).append("\n");
       }

       System.out.println(sb);
   }
}