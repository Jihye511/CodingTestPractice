import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] money;
    static int maxV = 0;
    static int hap=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        money = new int[N];
        for(int i =0; i<N; i++){
            money[i] = Integer.parseInt(br.readLine());
            hap += money[i];
            maxV = Math.max(maxV, money[i]);
        }
        System.out.println(binarySearch());

    }
    public static long  Withdrawal(long maxMoney){
        long tempday = maxMoney;
        long cnt =1;
        for(int m : money){
            if(tempday-m >=0){
                tempday-=m;
            }else{
                tempday = maxMoney-m; //인출하고 그날 쓴 돈 바로 빼기
                cnt++;
            }
        }
        return cnt;
    }
    public static long binarySearch(){
        long lo = maxV;
        long hi = hap;
        long result = 0;
        while(lo<=hi){
            long mid = lo +(hi-lo)/2;
            if(Withdrawal(mid) <= M){
                result = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return result;
    }
}