class Solution {
    //brute force
    private static boolean bruteForce(int n, int[][] rectangles){
        for(int r1=0;r1<=n;r1++){
            for(int r2=r1+1;r2<=n;r2++){
                int top=0;
                int mid=0;
                int down=0;
                boolean ans=true;
                for(int[] arr:rectangles){
                    int y1=arr[1];
                    int y2=arr[3];
                    if(y2<=r1){
                        down++;
                    }
                    else if(y1>=r2){
                        top++;
                    }
                    else if(y2<=r2 && y1>=r1){
                        mid++;
                    }
                    else{
                        ans=false;
                        break;
                    }
                }
                if(ans && top>0 && down>0 && mid>0){
                    return true;
                }
            }
        }
        for(int c1=0;c1<=n;c1++){
            for(int c2=c1+1;c2<=n;c2++){
                int left=0;
                int right=0;
                int mid=0;
                boolean ans=true;
                for(int[] arr:rectangles){
                    int x1=arr[0];
                    int x2=arr[2];
                    if(x2<=c1){
                        left++;
                    }
                    else if(x1>=c2){
                        right++;
                    }
                    else if(x2<=c2 && x1>=c1){
                        mid++;
                    }
                    else{
                        ans=false;
                        break;
                    }
                }
                if(ans && left>0 && right>0 && mid>0){
                    return true;
                }
            }
        }
        return false;
    }
    //better brute force
    private static boolean optimal(int n, int[][] rectangles){
        Set<Integer> ySet = new HashSet<>();
        Set<Integer> xSet = new HashSet<>();
        for(int[] r : rectangles){
            ySet.add(r[1]);
            ySet.add(r[3]);
            xSet.add(r[0]);
            xSet.add(r[2]);
        }
        List<Integer> yList = new ArrayList<>(ySet);
        Collections.sort(yList);
        List<Integer> xList = new ArrayList<>(xSet);
        Collections.sort(xList);
        for(int i = 0; i < yList.size(); i++){
            for(int j = i + 1; j < yList.size(); j++){

                int r1 = yList.get(i);
                int r2 = yList.get(j);
                int top = 0, mid = 0, down = 0;
                boolean valid = true;
                for(int[] arr : rectangles){
                    int y1 = arr[1];
                    int y2 = arr[3];
                    if(y2 <= r1) down++;
                    else if(y1 >= r2) top++;
                    else if(y1 >= r1 && y2 <= r2) mid++;
                    else {
                        valid = false;
                        break;
                    }
                }
                if(valid && top > 0 && down > 0 && mid > 0)
                    return true;
            }
        }
        for(int i = 0; i < xList.size(); i++){
            for(int j = i + 1; j < xList.size(); j++){
                int c1=xList.get(i);
                int c2=xList.get(j);
                int left=0,right=0,mid= 0;
                boolean valid = true;
                for(int[] arr : rectangles){
                    int x1 = arr[0];
                    int x2 = arr[2];
                    if(x2 <= c1) left++;
                    else if(x1 >= c2) right++;
                    else if(x1 >= c1 && x2 <= c2) mid++;
                    else {
                        valid = false;
                        break;
                    }
                }
                if(valid && left > 0 && right > 0 && mid > 0)
                    return true;
            }
        }

        return false;
    }
    //final optimal
    private boolean check(int[][] rects, int dim1, int dim2) {
        Arrays.sort(rects, (a, b) -> a[dim1] - b[dim1]);
        int n = rects.length;
        int[] suffixMin = new int[n];
        suffixMin[n-1] = rects[n-1][dim1];
        for(int i = n-2; i >= 0; i--){
            suffixMin[i] = Math.min(rects[i][dim1], suffixMin[i+1]);
        }
        int leftMax = rects[0][dim2];
        for(int i = 1; i < n-1; i++){
            if(leftMax <= rects[i][dim1]){
                int midMax = rects[i][dim2];
                for(int j = i+1; j < n; j++){
                    midMax = Math.max(midMax, rects[j-1][dim2]);
                    if(midMax <= suffixMin[j]){
                        return true;
                    }
                }
            }
            leftMax = Math.max(leftMax, rects[i][dim2]);
        }
        return false;
    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        //brute force passes 98% test cases
        // return bruteForce(n,rectangles);
        //brute better
        // return optimal(n,rectangles);
        if(check(rectangles, 0, 2)) return true;
        return check(rectangles, 1, 3);
        
    }
}