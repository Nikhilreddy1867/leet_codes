class Solution {
    private static boolean helper(char[] word,String str2,int m,int i){
        for(int j=0;j<m;j++){
            if(word[i+j]!=str2.charAt(j)) return false;
        }
        return true;
    }
    public String generateString(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int len=n+m-1;
        char[] ans=new char[len];
        Arrays.fill(ans,'$');
        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='T'){
                int ind=i;
                for(int k=0;k<str2.length();k++){
                    if(ans[ind] != '$' && ans[ind] != str2.charAt(k)) return "";
                    ans[ind]=str2.charAt(k);
                    ind++;
                }
            }
        }
        boolean[] change=new boolean[len];
        for(int i=0;i<len;i++){
            if(ans[i]=='$'){
                ans[i]='a';
                change[i]=true;
            }
        }
        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='F'){
                if(helper(ans,str2,m,i)){
                    boolean changed=false;
                    for (int k=i+m-1;k>=i;k--){
                        if(change[k]==true){
                            ans[k]='b';
                            changed=true;
                            break;
                        }
                    }
                    if(!changed) return "";
                }
            }
        }
        return new String(ans);
    }
}