import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        boolean[] visit = new boolean[arr.length];
        int index = 0; //오리 duck에서 현재 필요한 문자 인덱스
        char[] duck ={'q', 'u', 'a', 'c', 'k'};
        int count = 0;//오리 수

        //q로 시작하지 않거나 문자열이 5의 배수가 아니면 -1
        if(arr[0] != 'q' || arr.length%5 != 0){
            System.out.println("-1");
            return;
        }

        //arr 문자열 돌면서 해당 duck 값 list에 넣기
        for(int i = 0; i< arr.length; i ++){
            ArrayList<Character> list = new ArrayList<>();
            for(int j = i; j<arr.length; j++){
                if(!visit[j] && arr[j]==duck[index]){   //방문하지않았고 지금 찾고잇는 울음소리 문자와 같을때
                       index++;
                       list.add(arr[j]);
                       visit[j]=true;
                       if(index ==5){
                           index=0;
                       }
                }
            }
            //리스트에 들어간 값이 조건(quack)에 성립하지 않으면 -1
            if(list.size() != 0){
                if(list.get(list.size()-1)!='k'){
                    System.out.println("-1");
                    return;
                }
                count++;
            }
        }
        System.out.println(count);
    }

}