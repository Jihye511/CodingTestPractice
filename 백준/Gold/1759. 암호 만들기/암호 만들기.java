import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int L,C;
    static StringBuilder sb = new StringBuilder();
    static String [] input;

    static char[] vowels = {'a','e','i','o','u'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new String [C];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i<C; i++){
            input[i] = st.nextToken();
        }
        Arrays.sort(input);
        dfs("", 0,0);
        System.out.println(sb);
    }
    public static void dfs(String str, int depth,int start){
        if(depth ==L){
            if(check(str) ){ //최소 조건 만족하면 true
                sb.append(str).append("\n");
            }
            return;
        }
        if(start==C){
            return;
        }
        for( int i =start; i<C; i++){
            dfs(str +input[i],depth+1, i +1);
        }
    }
    public static boolean check(String str){
        char[] c = str.toCharArray();
        boolean[] check = new boolean[c.length];
        int cntV =0;
        int cntC=0;
        for(int i =0; i<c.length;i++){
            //모음 갯수 확인
            for(int j=0; j<vowels.length; j++){
                if(c[i] == vowels[j]){
                    cntV ++;
                    break;
                }
            }
        }
        if(cntV>0 && L-cntV >1) return true;
        return false;
    }

}