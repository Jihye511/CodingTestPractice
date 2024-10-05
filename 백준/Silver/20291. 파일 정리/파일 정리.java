import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static HashSet<String> hash = new HashSet<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt;
        Map<String,Integer> map = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        for(int i =0; i<N; i++){
            String input = br.readLine();
            String[] split = input.split("\\.");
            if(map.containsKey(split[1])){
                cnt = map.get(split[1]);
                map.put(split[1],++cnt);
            }else{
                map.put(split[1],1);
            }
        }
        //출력 정렬
        Object[] strings = map.keySet().toArray();

        Arrays.sort(strings);
        StringBuilder sb = new StringBuilder();
        for(Object a : strings){
            sb.append(a).append(" ").append(map.get(a));
            sb.append("\n");
        }
        System.out.println(sb);

    }
}