import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int cnt;
        for (int i =0; i<N; i++){
            String input = br.readLine();
            String[] split = input.split("\\.");
            if(map.containsKey(split[1])){
                cnt= map.get(split[1]);
                map.put(split[1],++cnt);
            }else{
                map.put(split[1],1);
            }

        }
        Object[] strings = map.keySet().toArray();
        Arrays.sort(strings);

        for(Object string : strings){
            sb.append(string +" ");
            sb.append(map.get(string));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}