import java.util.*;
import java.io.*;
public class Main {
    static int n, m, maxValue;
    static int[] card;
    public static void main(String[] rgs) throws IOException{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(br.readLine());

     n = Integer.parseInt(st.nextToken());
     m = Integer.parseInt(st.nextToken());
     card = new int[n];
     st = new StringTokenizer(br.readLine());
     for(int i =0; i<n; i++){
      card[i] = Integer.parseInt(st.nextToken());
     }
     maxValue = 0;
     int temp = 0;
     for ( int i =0; i<n-2; i++){
      for(int j = i+1; j<n-1; j++){
       for(int k = j+1; k<n; k++){
           temp = card[i] + card[j] + card[k];
           if(maxValue<temp && temp<=m){
               maxValue = temp;
           }
       }
      }
     }


        System.out.println(maxValue);
    }
 }