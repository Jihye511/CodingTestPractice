import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt;
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i<N; i++){
            String input = br.readLine();
            String[] split = input.split("\\.");

            if(map.containsKey(split[1])){
                cnt = map.get(split[1]);
                map.put(split[1],++cnt);
            }
            else{
                map.put(split[1],1);
            }
        }
        //출력 정렬
        Object[] strings = map.keySet().toArray();
        Arrays.sort(strings);

        StringBuilder sb = new StringBuilder();
        for(Object string : strings){
            sb.append(string +" " );
            sb.append(map.get(string));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}