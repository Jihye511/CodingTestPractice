import java.io.*;
import java.util.*;

public class Main {
    /*
    비슷한 단어 조건
    1. 두 문자의 구성(개수, 종류)가 모두 같을 떄
    2. 한 단어에서 한 문자르 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸었을 때 같게 되면
     */
   static int N;
   static String input;
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       input = br.readLine();
       int len = input.length();
       int ans=0;
       HashMap<Character, Integer>origin = new HashMap<>();
       for(char c : input.toCharArray()){
           origin.put(c, origin.getOrDefault(c,0)+1);
       }
       for(int i =1; i<N; i++){
           HashMap<Character,Integer> map = new HashMap<>(origin);
           String word = br.readLine();
            int num=0;//차이나는 개수
           for(char temp : word.toCharArray()){
               if(map.containsKey(temp)){
                   if(map.get(temp)>0){
                       map.put(temp,map.get(temp)-1);
                       if(map.get(temp)==0) map.remove(temp);
                   }else num++;
               }else num++;
           }
           if(len> word.length()){
               for(Character key: map.keySet()){
                   num++;
               }
           }
           if(Math.abs(num)<2) ans++;
       }
       System.out.println(ans);
   }

}