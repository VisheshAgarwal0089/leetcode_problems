class Solution {
    private long pt[][];
    private long mod= 1_000_000_007L;
    private long solve(List<Integer> nums){
        int n=nums.size();
        if(n<3)return 1;
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        int root=nums.get(0);
        for(int i=1;i<n;i++){
            if(root<nums.get(i)){
                right.add(nums.get(i));
            }
            else{
                left.add(nums.get(i));
            }
        }
        long x=solve(left)%mod;
        long y=solve(right)%mod;
        return (((x*y)%mod)*pt[n-1][left.size()])%mod;
    }
    public int numOfWays(int[] nums) {
        int n=nums.length;
        pt=new long[n+1][];
        for(int i=0;i<=n;i++){
            pt[i]=new long[i+1];
            Arrays.fill(pt[i],1);
            for(int j=1;j<i;j++){
                pt[i][j]= (pt[i-1][j]+pt[i-1][j-1])%mod;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        return (int)((solve(list)-1+mod)%mod);
    }
}