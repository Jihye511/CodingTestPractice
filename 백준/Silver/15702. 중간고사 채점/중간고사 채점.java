import java.io.*;
import java.util.*;
public class Main {
    static class Student implements Comparable<Student> {
        int num;
        int score;
        public Student(int num, int score){
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if(this.score == o.score) return this.num - o.num;
            else return o.score - this.score;
        }
    }
    static int N;
    static int[] h;
    static Student[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] score = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }
        s = new Student[M];
        int[] getScore = new int[M];
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int hap = 0;
            for(int j =0; j<N; j++){
                char ch = st.nextToken().charAt(0);
                if(ch =='O') hap += score[j];
            }
            s[i] = new Student(n, hap);
        }
        Arrays.sort(s);
        System.out.println(s[0].num +" " + s[0].score);

    }
}
