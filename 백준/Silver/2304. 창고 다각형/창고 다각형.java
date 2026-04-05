import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int maxX= 0;
       int maxY = 0;
       int N = Integer.parseInt(br.readLine());
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i =0; i<N; i++){
           StringTokenizer st= new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           if(maxY <y){
               maxY = Math.max(maxY,y);
               maxX = x;
           }
           maxY = Math.max(maxY,y);
           map.put(x,y);
       }
       int size=0;
       Map<Integer, Integer> sortedMap = new TreeMap<>(map);
       Set<Integer> keySet = sortedMap.keySet();
       // 최고 높이의 가장 왼쪽, 가장 오른쪽 위치 찾기
       int leftMaxX = -1;
       int rightMaxX = -1;

       for (int k : keySet) {
           if (sortedMap.get(k) == maxY) {
               if (leftMaxX == -1) leftMaxX = k;
               rightMaxX = k;
           }
       }
       int nx =-1;
       int ny =-1;
       //왼쪽부터 출발
       for(int k : keySet){
           if(nx ==-1 && ny ==-1){
               nx = k;
               ny = sortedMap.get(k);
               continue;
           }
           int height =sortedMap.get(k);
           if(leftMaxX == k) {
               size += (k-nx)*ny;
               break;
           }

           if(ny<height){
               size += (k-nx)*ny;
               ny = height;
               nx = k;
           }
       }
       //오른쪽 계산
       ArrayList<Integer> key = new ArrayList<>(keySet);
       for(int i = sortedMap.size()-1; i>=0; i--){
           int k = key.get(i);
           if(i == sortedMap.size()-1){
               nx = k;
               ny = sortedMap.get(k);
               continue;
           }
           int height =sortedMap.get(k);
           if(rightMaxX == k) {
               size += (nx - k) * ny;
               break;
           }
           if(ny<height){
               size += (nx-k)*ny;
               ny = height;
               nx = k;
           }

       }
       size += (rightMaxX - leftMaxX +1)*maxY;
       System.out.println(size);

   }
}