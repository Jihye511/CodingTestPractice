import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] loc = new int[M];
        for(int i =0; i<M; i++){
            loc[i] = Integer.parseInt(st.nextToken());
        }
        int start =0;
        int end = N;
        while(start<end){
            int mid = (end - start)/2 + start;
            if(checkDist(mid,loc,N)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        System.out.println(end);
    }
    //모두 비추는지 체크
    public static boolean checkDist(int len, int[] loc, int N){
        int last = 0;
        for(int i =0; i<loc.length; i++){
            int cur = loc[i];
            int start = cur-len;
            int end = cur +len;
            if(start >last) return false;

            last =end;
        }

        return last >= N;
    }

}