class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        ArrayList<Integer> list=new ArrayList<>();
        if(s<=1){
            return list;
        }
        int arr[]=new int[n+1];
        Arrays.fill(arr,1);
        arr[0]=arr[1]=0;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(arr[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    arr[j]=0;
                }
            }
        }
        int sum=0;
        // int i=2;
       for(int i=2;i<=n;i++){
           if(arr[i]==1){
               if(sum+i<=s){
                   sum+=i;
                   list.add(i);
               }
               else{
                   break;
               }
           }
       }
        return list;
    }
}