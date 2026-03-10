import javax.imageio.ImageTranscoder;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
   public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
        int N  = Integer.parseInt(br.readLine());
        int[] city = new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        int sum=0;
        for(int i =0; i<N; i++){
            city[i] = Integer.parseInt(st.nextToken());
            sum+= city[i];
        }
       Arrays.sort(city);
        int M = Integer.parseInt(br.readLine());

        if(sum<=M) {
            System.out.println(city[N-1]);
            return;
        }
        int lo = 1;
        int hi = city[N-1];
        int ans = 0;
        while(lo<=hi){
            int mid = (hi-lo)/2 + lo;
            if(isEnough(city,M,mid)){
                ans = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
       System.out.println(ans);



   }
   public static boolean isEnough(int[] city, int M, int mid){
       long sum = 0;
       for(int i:city){
           if(i<mid) sum+=i;
           else sum+=mid;
       }
       return sum<=M;
   }
}