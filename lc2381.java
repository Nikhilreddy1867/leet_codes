class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] diff=new int[n];
        for(int[] arr:shifts){
            int start=arr[0];
            int end=arr[1];
            int dir=arr[2];
            if(dir==1){
                diff[start]+=1;
                if(end+1<n){
                    diff[end+1]-=1;
                } 
            }
            else{
                diff[start]-=1;
                if(end+1<n){
                    diff[end+1]+=1;
                }
            }
        }
        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int shift=diff[i]%26;
            if(shift<0){
                shift+=26;
            }
            char temp=(char)(((s.charAt(i)-'a'+shift)%26)+'a');
            sb.append(temp);
        }
        return sb.toString();
    }
}