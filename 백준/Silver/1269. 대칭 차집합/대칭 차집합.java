import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
       ArrayList<Integer> listA = new ArrayList<>();
       ArrayList<Integer> listB = new ArrayList<>();
       HashMap<Integer, Integer> mapA = new HashMap<>();
       HashMap<Integer, Integer> mapB = new HashMap<>();
       st= new StringTokenizer(br.readLine());
       for(int i =0; i<a; i++){
           int n = Integer.parseInt(st.nextToken());
           listA.add(n);
           mapA.put(n,mapA.getOrDefault(n,0)+1);
       }
       st= new StringTokenizer(br.readLine());
       for(int i=0; i<b; i++){
           int n = Integer.parseInt(st.nextToken());
           listB.add(n);
           mapB.put(n,mapB.getOrDefault(n,0)+1);
       }
       //a 차집합 개수
       for(int  n : listB){
           if(mapA.containsKey(n)){
               int temp = mapA.get(n)-1;
               if(temp ==0 )mapA.remove(n);
               else mapA.put(n,temp);
           }
       }
       //b 차집합 개수
       for(int n :listA){
           if(mapB.containsKey(n)){
               int temp = mapB.get(n)-1;
               if(temp==0)mapB.remove(n);
               else mapB.put(n,temp);
           }
       }
       System.out.println(mapA.size() + mapB.size());
   }
}