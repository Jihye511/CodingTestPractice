import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N  = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        HashSet<String> set = new HashSet<>();
        for(int i =0; i<N; i++){
            set.add(br.readLine());
        }
        if(type.equals("Y")){
            System.out.println(set.size()/1);
        }else if(type.equals("F")){
            System.out.println(set.size()/2);
        }else if(type.equals("O")){
            System.out.println(set.size()/3);
        }
    }

}