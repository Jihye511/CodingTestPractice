import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
 
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            // 이전 숫자와 현재 숫자가 다르면 리스트에 추가
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}