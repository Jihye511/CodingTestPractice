import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=N; i++){
            int input = Integer.parseInt(st.nextToken());
            if(input ==1) button[i] = true;
            else button[i] =false;
        }
        int stuN = Integer.parseInt(br.readLine());
        for(int i =0; i<stuN; i++){
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            if(student == 1){
                int multiple = number;
                while(multiple <=N){
                    button[multiple] = !button[multiple];
                    multiple +=number;
                }
            }else{
                button[number] = !button[number];

                int temp =1;
                while(number- temp>0 && number+temp <=N){
                    int pre = number -temp;
                    int pos = number +temp;
                    if(button[pre] == button[pos]){
                        button[pre] = !button[pre];
                        button[pos] = !button[pos];
                    }else break;

                    temp++;
                }

            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =1; i<=N; i++){
            if(button[i]){
                list.add(1);
            }else list.add(0);
        }
        for(int i =0; i<list.size(); i++){
            if(i !=0 && i%20==0) System.out.println();
            System.out.print(list.get(i)+" ");

        }
    }

}