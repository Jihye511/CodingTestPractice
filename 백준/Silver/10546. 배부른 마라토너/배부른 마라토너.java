import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0; i<n; i++){
            String s = br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(int i =0; i<n-1; i++){
            String s = br.readLine();
            int value = map.get(s)-1;
            if(value==0) map.remove(s);
            else map.put(s,value);
        }
        List<String> list = new ArrayList<>(map.keySet());
       System.out.println(list.get(0));
   }
}