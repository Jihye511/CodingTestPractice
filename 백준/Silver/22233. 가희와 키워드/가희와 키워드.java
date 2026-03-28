import javax.imageio.ImageTranscoder;
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args)throws IOException {
       StringBuilder sb = new StringBuilder();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String ,Integer> map = new HashMap<>();
        for(int i =0; i<N; i++){
            String str = br.readLine();
            map.put(str, 1);
        }
        for(int i =0; i<M; i++){
            String input =br.readLine();
            String[] str =input.split(",");
            for(String s : str){
                if(map.containsKey(s)) {
                    map.remove(s);
                }
            }
            sb.append(map.size()).append("\n");
        }
       System.out.println(sb);
   }
}