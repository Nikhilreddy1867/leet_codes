class Solution {
    private static boolean helper(String part){
        if(part.length()==1) return true;
        if(part.charAt(0)=='0') return false;
        int num=Integer.parseInt(part);
        if(num>=1 && num<=255) return true;
        return false;
    }
    private static void rec(int ind,String s,List<String> temp,List<String> ans,int n){
        if(temp.size()==4){
            if(ind==n){
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<temp.size();i++){
                    if(i!=0){
                        sb.append('.');  
                    }
                    sb.append(temp.get(i));
                }
                ans.add(sb.toString());
            }
            return;
        }
        for(int i=1;i<=3;i++){
            if(ind+i>n) break;
            String part=s.substring(ind,ind+i);
            if(helper(part)){
                temp.add(part);
                rec(ind+i,s,temp,ans,n);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        int n=s.length();
        List<String> temp=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        rec(0,s,temp,ans,n);
        return ans;
    }
}