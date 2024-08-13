import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(bf.readLine());
        for (int i =1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }



        for(int i=0; i<m; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            switch (a){
                case 1:
                    arr[b]=c;
                    break;
                case 2:
                    for(int j =b; j<=c; j++) arr[j]^=1;
                    break;
                case 3:
                    for(int j =b; j<=c; j++) arr[j]=0;
                    break;
                case 4:
                    for(int j =b; j<=c; j++) arr[j]=1;
                    break;
            }
        }
        for(int i =1; i<=n; i++)
            sb.append(arr[i] + " ");
        System.out.println(sb);
    }

}