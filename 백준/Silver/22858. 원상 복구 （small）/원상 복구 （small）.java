import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr,D,temp;
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        arr = new int[N+1];
        D = new int[N+1];

        s = br.readLine().split(" ");

        //k번 섞은 배열
        for(int i= 1; i<=N; i++){
            arr[i] = Integer.parseInt(s[i-1]);
        }
        s= br.readLine().split(" ");
        //D 입력받기
        for(int i =1; i<=N; i++){
            D[i] = Integer.parseInt(s[i-1]);
        }

        for(int i=0; i<K; i++){
            temp = new int[N+1];
            for(int j =0; j<=N; j++){
                temp[D[j]] = arr[j];
            }
            arr= temp;
        }

        for(int i =1; i<=N; i++){
            sb.append(arr[i] +" ");
        }
        System.out.println(sb.toString());



    }


}