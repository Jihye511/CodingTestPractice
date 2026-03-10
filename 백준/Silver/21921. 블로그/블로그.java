import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int X =Integer.parseInt(st.nextToken());
       st= new StringTokenizer(br.readLine());
       int[] day=new int[N];
       long max = 0;
       for(int i =0; i<N; i++){
           day[i]=Integer.parseInt(st.nextToken());
           max =Math.max(max, day[i]);
       }
        if(max==0){
            System.out.println("SAD");
            return;
        }
        long sum =0;

        for(int i =0; i<X; i++){
            sum+=day[i];

        }
       long maxV = sum;
        int end =X-1;
        int start = 0;

        while(end<N-1){
            end++;
            sum -=day[start];
            sum +=day[end];
            maxV = Math.max(sum, maxV);
            start++;
        }
        int cnt =0;

        end = X;
        start =0;
        sum=0;
       for(int i =0; i<X; i++){
           sum+=day[i];
       }
       if(sum==maxV) cnt++;
       while(end<N){
           sum-=day[start];
           sum +=day[end];
           if(sum == maxV)cnt++;
           start++;
           end++;
       }
       System.out.println(maxV);
       System.out.println(cnt);

   }
}