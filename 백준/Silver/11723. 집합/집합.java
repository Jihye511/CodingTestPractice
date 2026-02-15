import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num;
            if(str.equals("add")){
                num = Integer.parseInt(st.nextToken());
                set.add(num);
            }else if(str.equals("check")){
                num = Integer.parseInt(st.nextToken());
                if(set.contains(num)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(str.equals("remove")){
                num = Integer.parseInt(st.nextToken());
                set.remove(num);
            }else if(str.equals("toggle")){
                num = Integer.parseInt(st.nextToken());
                if(set.contains(num)) set.remove(num);
                else set.add(num);
            }else if(str.equals("all")){
                for(int i =1;i<=20; i++){
                    set.add(i);
                }
            }else if(str.equals("empty")){
                set.clear();
            }
        }
        System.out.println(sb);
    }
}