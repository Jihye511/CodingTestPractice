class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i =0; i<absolutes.length; i++){
            if(!signs[i]){
                absolutes[i] = -absolutes[i];
            }
        }
        for(int val : absolutes){
            answer += val;
        }
        return answer;
    }
}