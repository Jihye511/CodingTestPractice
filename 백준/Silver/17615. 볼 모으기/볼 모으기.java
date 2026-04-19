import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());
        String str= br.readLine();

//        for(char c : str.toCharArray()){
//            if(c=='B') blue++;
//            else if(c=='R') red++;
//        }
        int minValue = Integer.MAX_VALUE;

        //파랑 왼쪽으로
        int blue =0;
        boolean change = false;
        for(int i =0; i<str.length(); i++){
            if(!change && str.charAt(i)=='B') continue;
            else if (!change && str.charAt(i)!='B') change = true;
            else if(change){
                if(str.charAt(i)=='B') blue++;
            }
        }
        minValue = Math.min(minValue,blue);
        int red=0;
        //빨강 왼쪽으로
        change = false;
        for(int i =0; i<str.length(); i++){
            if(!change && str.charAt(i)=='R') continue;
            else if (!change && str.charAt(i)!='R') change = true;
            else if(change){
                if(str.charAt(i)=='R') red++;
            }
        }
        minValue = Math.min(minValue,red);
        //파랑 올ㄴ쪽
        blue =0;
        change = false;
        for(int i =str.length()-1; i>=0; i--){
            if(!change && str.charAt(i)=='B') continue;
            else if (!change && str.charAt(i)!='B') change = true;
            else if(change){
                if(str.charAt(i)=='B') blue++;
            }
        }
        minValue = Math.min(minValue,blue);
        //빨강 오른쪽
        red=0;
        change = false;
        for(int i =str.length()-1; i>=0; i--){
            if(!change && str.charAt(i)=='R') continue;
            else if (!change && str.charAt(i)!='R') change = true;
            else if(change){
                if(str.charAt(i)=='R') red++;
            }
        }
        minValue = Math.min(minValue,red);
        System.out.println(minValue);
    }
}