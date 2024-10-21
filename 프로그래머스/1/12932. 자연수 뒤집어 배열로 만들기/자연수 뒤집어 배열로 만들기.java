class Solution {
    public int[] solution(long n) {
        
        // String str = Long.toString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.reverse();
        String str = sb.toString();
        int[] answer = new int[str.length()];
        
        for(int i =0; i<str.length(); i++){
            answer[i] = str.charAt(i) -'0';
        }
        
        return answer;
    }
}