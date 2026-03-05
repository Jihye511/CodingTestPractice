import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       HashMap<String, Integer> map = new HashMap<>();
       for(int i =0; i<n; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           String name = st.nextToken();
           String info = st.nextToken();
           map.put(name, map.getOrDefault(name, 0)+1);
       }
        ArrayList<String> list= new ArrayList<>();
       for(String key : map.keySet()){
           if(map.get(key)%2==0) continue;
           else list.add(key);
       }
       Collections.sort(list, Collections.reverseOrder());
       for(String s : list){
           System.out.println(s);
       }

   }
}