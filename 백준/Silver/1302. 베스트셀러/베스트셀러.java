import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       HashMap<String, Integer> map = new HashMap<>();
       while(N-->0){
           String str = br.readLine();
           map.put(str, map.getOrDefault(str,0)+1);
       }
       List<String> keySet = new ArrayList<>(map.keySet());
       Collections.sort(keySet, (o1,o2)->map.get(o2)-map.get(o1));
       int max= map.get(keySet.get(0));

       ArrayList<String> list = new ArrayList<>();
       list.add(keySet.get(0));
       for(String s : keySet){
           if(map.get(s) == max) list.add(s);
           else break;
       }
       if(list.size()==1){
           System.out.println(list.get(0));
       }else{
           Collections.sort(list, (o1,o2)->o1.compareTo(o2));
           System.out.println(list.get(0));
       }
   }
}