class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target){
        for(int i=arr.length-1;i>=0;i--){
            int small=0;
            int a=0;
            for(int j=0;j<=i;j++){
                if(arr[j]>small){
                    small=arr[j];
                    a=j;
                }
            }
           arr= swap(a,i,arr);         
        }
        boolean[]vis=new boolean[arr.length];
       return solve(arr,target,new ArrayList<Integer>(),0,vis);
    }
    public int[] swap(int i,int j,int[]arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
    public List<List<Integer>> solve(int[]arr,int tar,ArrayList<Integer>ans,int vidx,boolean[]vis){
        if(tar==0){
            List<List<Integer>>a=new ArrayList<>();
            List<Integer>temp=new ArrayList<>();
            temp.addAll(ans);
            a.add(temp);
            
            return a;
        }
        if(vidx==arr.length){
                List<List<Integer>>a=new ArrayList<>();
            return a; 
        }
        
                    List<List<Integer>>aa=new ArrayList<>();
        if(!(vidx!=0 && arr[vidx]==arr[vidx-1] && !vis[vidx-1])){
        if(tar-arr[vidx]>=0){
            vis[vidx]=true;
            ans.add(arr[vidx]);
           aa.addAll(solve(arr,tar-arr[vidx],ans,vidx+1,vis));
            ans.remove(ans.size()-1);
            vis[vidx]=false;
        }}
         aa.addAll(solve(arr,tar,ans,vidx+1,vis));
        
        return aa;

    }
}