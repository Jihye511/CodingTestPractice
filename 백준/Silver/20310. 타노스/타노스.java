import javax.imageio.ImageTranscoder;
import java.io.*;
import java.text.CollationElementIterator;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int oneC=0;
        int zeroC=0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i =0; i<str.length(); i++){
            int n = str.charAt(i)-'0';
            if(n ==1) oneC++;
            else if(n==0) zeroC++;
            q.offer(n);
        }
        ArrayDeque<Integer>secondQ = new ArrayDeque<>();
        oneC = oneC/2;
        zeroC = zeroC/2;
        //1은 앞에서부터 싹 빼기
       while(oneC>0){
           int cur = q.poll();
           if(cur == 1) oneC--;
           else{
               secondQ.add(cur);
           }
       }
       for(int i : q){
           secondQ.add(i);
       }
       //0은 뒤에서 부터 싹 빼기
       while(zeroC>0){
           int cur = secondQ.pollLast();
           if(cur ==0)  zeroC--;
           else{
               sb.append(cur);
           }
       }
       int len = secondQ.size();
       for(int i =0; i<len; i++){
           sb.append(secondQ.pollLast());
       }
       System.out.println(sb.reverse());
   }

}