import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
       int N  = Integer.parseInt(st.nextToken());
       int K  =Integer.parseInt(st.nextToken());

       String str= br.readLine();
       int count =0;
       Queue<Integer> qP = new LinkedList<>(); //사람
       Queue<Integer> qH = new LinkedList<>(); //햄버거
       for(int i=0; i<str.length(); i++){
           if(str.charAt(i)=='P'){
               boolean eat =false;
               if(!qH.isEmpty()){
                   while(!qH.isEmpty()){
                       int hamburger = qH.poll();
                       if(hamburger >=i-K && hamburger<=i+K){
                           count++;
                           eat =true;
                           break;
                       }
                   }
                   if(!eat) qP.add(i);
               }else  qP.add(i);


           }else{
               //햄버거일때
               boolean eat =false;
               if(!qP.isEmpty()){
                   while(!qP.isEmpty()){
                       int h  = qP.poll();
                       if(h>=i-K && h<=i+K){
                           count++;
                           eat = true;
                           break;
                       }
                   }
                   if(!eat) qH.offer(i);
               }else qH.offer(i);

           }
       }
       System.out.println(count);
   }
}