import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static String input;
    static char[] c;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> hash;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(N-->0){
            input = br.readLine();
            c = input.toCharArray();
            visited = new int[26]; //알파벳 소문자 26개에 대해 방문 횟수 저장
            hash  = new HashSet<>();
            for( char ch : c){
                visited[ch-'a']++;
            }
            dfs("");
            ArrayList<String> ans = new ArrayList<>(hash);
            Collections.sort(ans);
            for(String val : ans){
                sb.append(val).append("\n");
            }
        }

        System.out.println(sb);
    }
    public static void dfs(String str){
        if(str.length() == input.length()){
            hash.add(str);
            return;
        }
        for(int i =0; i<26; i++){
            if(visited[i]>0){   //방문가능할 때
                visited[i]--;   //사용
                dfs(str + (char) (i+'a'));  //현재 문자 추가
                visited[i]++;   //복원
            }
        }
    }
}
