import java.util.*;
import java.io.*;

public class Main{
    static String str;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        System.out.println(poliomino(str));

    }
    public static String poliomino(String s){
        String ans ="";
        String A ="AAAA";
        String B ="BB";

        s= s.replace("XXXX",A);
        ans = s.replace("XX",B);
        if(ans.contains("X")){
            ans ="-1";
        }
        return ans;
    }
}