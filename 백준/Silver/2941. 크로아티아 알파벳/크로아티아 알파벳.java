import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt=0;
        String[] croatia = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
        for (String c : croatia){
            str = str.replace(c,"*");
        }

        System.out.println(str.length());
    }
}