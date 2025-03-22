import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] lecture;
    static long sum=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        lecture = new int[N];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            lecture[i] = Integer.parseInt(st.nextToken());
        }

        for(int n : lecture){
            sum += n;
        }
        System.out.println(binarySearch());
    }
    public static long countBlueray(long size){
        long cnt =1;
        long hap=0;
        for(int v : lecture){
            if(hap + v<= size){
                hap+=v;
            }else{
                if(v >size){
                    return M+1;
                }
                hap = v;
                cnt++;
            }
        }
        return cnt;
    }

    public static long binarySearch(){
        long lo = lecture[N-1];
        long hi = sum;
        long answer = 0;
        while(lo<=hi){
            long mid = lo+(hi-lo)/2;
            if(countBlueray(mid)<=M){
                answer = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return answer;
    }
}