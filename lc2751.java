class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=positions.length;
        int[][] arr=new int[n][4];
        for(int i=0;i<n;i++){
            arr[i][0]=positions[i];
            arr[i][1]=healths[i];
            arr[i][2]=directions.charAt(i);
            arr[i][3]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(arr[i][2]=='R'){
                st.push(i);
            }
            else{
                while(!st.isEmpty() && arr[i][1]>0){
                    int ind=st.peek();
                    if(arr[i][1]>arr[ind][1]){
                        arr[i][1]--;
                        arr[ind][1]=0;
                        st.pop();
                    }
                    else if(arr[ind][1]>arr[i][1]){
                        arr[ind][1]--;
                        arr[i][1]=0;
                        break;
                    }
                    else{
                        arr[ind][1]=0;
                        arr[i][1]=0;
                        st.pop();
                        break;
                    }
                }
            }
        }
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i][1]>0){
                ans.add(arr[i]);
            }
        }
        Collections.sort(ans,(a,b)->a[3]-b[3]);
        List<Integer> ansf=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            ansf.add(ans.get(i)[1]);
        }
        return ansf;
    }
    
}