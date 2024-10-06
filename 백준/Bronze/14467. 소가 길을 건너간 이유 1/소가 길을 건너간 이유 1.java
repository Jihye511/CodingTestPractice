import java.io.*;
import java.util.*;
public class Main {
    static int N,cnt;
    static int[] cowList;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cowList = new int[11];
        Arrays.fill(cowList,-1);
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int locate = Integer.parseInt(st.nextToken());

            if(cowList[cow]==-1){
                cowList[cow] =locate;
            }else if(cowList[cow] !=locate){
                cowList[cow] =locate;
                cnt++;
            }else continue;

        }
        System.out.println(cnt);
    }
}