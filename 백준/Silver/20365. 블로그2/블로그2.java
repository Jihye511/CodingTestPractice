import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static char[] s;
    static int blue=0;
    static int red=0;
    static int result=0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        s = new char[n];
        String str = br.readLine();
        for(int i =0; i<n; i++){
            s[i] = str.charAt(i);
        }
        char before='X';
        for(int i =0; i<n; i++){
            if(s[i] !=before){
                if(s[i]=='R') red++;
                else if(s[i]=='B')blue++;
                before = s[i];
            }
        }
        result = Math.min(red,blue) +1;
        System.out.println(result);

    }
}