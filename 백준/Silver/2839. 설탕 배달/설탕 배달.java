import javax.lang.model.type.ArrayType;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[]dp;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        Arrays.fill(arr,1700);
        if(N <=5){
            arr[N] = N/3;
            if(N%3 !=0 && N%5!=0){
                arr[N] +=1;
            }
        }else{
            arr[3] =1;
            arr[4] =2;
            arr[5] =1;
            for(int i =6;i<=N; i++){
                arr[i] = Math.min(arr[i-5] +1,arr[i-3] +1);
            }
        }
        if(N ==4 ||N ==7){
            System.out.println(-1);
        }else{
            System.out.println(arr[N]);
        }

    }
}