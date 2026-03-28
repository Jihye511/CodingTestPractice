import javax.imageio.ImageTranscoder;
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st= new StringTokenizer(br.readLine());
        int N  =Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, String> temp = new HashMap<>();
        for(int i =0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(temp.containsKey(num))continue;

            temp.put(num,str);
            map.put(num, str);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1,o2)-> o1-o2);

        for(int i =0; i<M; i++){
            int score = Integer.parseInt(br.readLine());
            sb.append(map.get(binary(keySet,map,score))).append("\n");
        }
       System.out.println(sb);

   }
    public static int binary(List<Integer> key,HashMap<Integer ,String> map, int score){
       int lo=0;
       int hi=map.size();
       int mid ;
       while(lo<hi){
           mid = (hi-lo)/2 + lo;
           if(key.get(mid)<score){
                lo = mid+1;
           }else{
               hi = mid;
           }
       }
       return key.get(hi);
    }
}