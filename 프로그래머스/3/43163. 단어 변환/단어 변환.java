import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<Integer> cntList = new ArrayList<>();
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        if(!isThere(target,words)){
            return 0;
        }
        
        dfs(begin,target,words,0,0);
        
        Collections.sort(cntList);
        answer = cntList.get(0);
        
        return answer;
    }
    public static void dfs(String begin, String target, String[] words, int idx, int cnt){
        if(begin.equals(target)){
            cntList.add(cnt);
            return;
        }
        if(idx >= words.length) return;
        for(int i =0; i<words.length; i++){
            if(!visited[i]){
                if(checkChange(begin, words[i])){ //한개 바꿀수 있으면 그걸로 저장
                    String nextWord = words[i];
                    visited[i] =true;
                    dfs(nextWord, target,words,i+1, cnt+1);
                    visited[i] =false;
                }
            }
            
        }
    }
    public static boolean checkChange(String begin, String word){
        char [] begin_c = begin.toCharArray();
        char[] word_c = word.toCharArray();
        int count=0;
        for(int i =0; i<begin.length(); i++){
            if(begin_c[i]!=word_c[i]){
                count ++;
            }
        }
        if(count ==1) return true;
        else{
            return false;
        }
    }
    public static boolean isThere(String target , String[]words){
        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])){
                return true;
            }
        }
        return false;
    }
}