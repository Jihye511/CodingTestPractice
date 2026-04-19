import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str= br.readLine();
        int cntA =0;
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i)=='a') cntA++;
        }
        int min = Integer.MAX_VALUE;
        for(int i =0; i<str.length(); i++){
            int cntB=0;
            for(int j=i; j<cntA+i; j++){
                if(str.charAt(j % str.length()) == 'b') cntB++;
            }
            min = Math.min(min, cntB);
        }
        System.out.println(min);
    }
}