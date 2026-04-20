import java.io.*;
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i =0; i<phone_book.length-1; i++){
            String cur = phone_book[i];
            for(int j =i+1; j<phone_book.length; j++){
                if(phone_book[j].startsWith(cur)){
                    answer = false;
                    break;
                }
                else break;
            }
            if(!answer) break;
        }
        return answer;
    }
}