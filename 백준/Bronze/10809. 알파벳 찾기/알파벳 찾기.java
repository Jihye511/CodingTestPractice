import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] askii = new int[26];
        Arrays.fill(askii,-1);
        String str = br.readLine();
        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            if(askii[(int)c -97] !=-1) continue;
            askii[(int)c -97] =i;
        }
        for(int i=0; i<26; i++){

            sb.append(askii[i]+" ");
        }
        System.out.println(sb);

    }
}