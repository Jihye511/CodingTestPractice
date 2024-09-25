import java.util.*;
import java.io.*;
public class Main{
    static long N;
    static long M;
    static long[] office;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        office = new long[(int)N];
        for(int i=0; i<N; i++) {
            office[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(office);

        bSearch();

    }
    public static void bSearch(){
        long start =1;
        long end = M*office[(int)N-1];
        long result = 0;
        while(start<=end){
            long mid = (start+end)/2;
            //mid초 일떄 심사 가능 인원수 계산
            long cnt=0;
            for(int i =0;i<N;i++){
                cnt += (mid/office[i]);
                if(cnt >=M){
                    break;
                }
            }
            //cnt>M -> 초를 줄여야...
            if(cnt>=M){
                end = mid-1;

            }else{
                start = mid+1;
            }
        }
        System.out.println(start);

    }
}