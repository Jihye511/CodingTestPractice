import java.io.*;
import java.util.*;

public class Main {
    static class Person{
        int w;
        int h;
        public Person(int w, int h){
            this.w = w;
            this.h =h;
        }
    }
    static Person[] person;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        person = new Person[n];
        for(int i =0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            person[i]= new Person(w,h);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
            int count=0;
            for(int j =0; j<n; j++){
                if( i==j) continue;
                if(person[i].w < person[j].w && person[i].h< person[j].h){
                    count++;
                }
            }
            sb.append(count+1).append(" ");
        }
        System.out.println(sb);
    }

}