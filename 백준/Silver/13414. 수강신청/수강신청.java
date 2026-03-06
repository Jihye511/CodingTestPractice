import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st= new StringTokenizer(br.readLine());
       int K = Integer.parseInt(st.nextToken());
       int L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i<L; i++){
            map.put(br.readLine(),i);
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->a.getValue() - b.getValue());

        for(int i =0; i<Math.min(K,list.size()); i++){
           System.out.println(list.get(i).getKey());
       }
   }
}