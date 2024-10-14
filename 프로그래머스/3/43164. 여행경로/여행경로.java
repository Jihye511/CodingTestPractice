import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs("ICN",0,"ICN",tickets);
        Collections.sort(list);
        // String[] answer = new String[list.size()];
        // for (int i = 0; i < list.size(); i++) {
        //     answer[i] = list.get(i);
        // }
        return list.get(0).split(" ");
    
    }
    public static void dfs(String now, int depth,String path, String[][] tickets){
        if(depth == tickets.length){
            list.add(path);
        }
        for(int i =0;i<tickets.length; i++){
            if(!visited[i] && now.equals(tickets[i][0])){
                visited[i]=true;
                dfs(tickets[i][1],depth+1, path +" "+ tickets[i][1], tickets);
                visited[i] =false;
            }
        }
    }
}