class Solution {
    public boolean solution(String s) {
        if(s.length()==4 || s.length() == 6) {
            int[] c =new int[s.length()];
            for(int i =0; i<s.length(); i++){
                c[i] = (int)s.charAt(i);
                if(c[i]<48 || c[i]>57) return false; 
            }
            return true;
            
        }
        return false;
        
    }
}