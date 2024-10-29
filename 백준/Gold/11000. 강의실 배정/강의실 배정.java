import java.io.*;
import java.util.*;
class Pair{
    int start;
    int end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Main {
    static int N;

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Pair[] meetings = new Pair[N];

        for(int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Pair(start,end);
        }
        Arrays.sort(meetings, (a,b)->{
            if( a.start == b.start){
                return a.end-b.end;
            }
            return a.start - b.start;
        });
        pq.offer(meetings[0].end); //첫회의 추가

        for(int i =1; i<N; i++){
            if(pq.peek() <=meetings[i].start){
                pq.poll();
            }
            pq.offer(meetings[i].end);
        }


        System.out.println(pq.size());
    }

}