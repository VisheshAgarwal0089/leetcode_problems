class Solution {
    public int totalNumbers(int[] arr) {
        int n = arr.length;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(i==j||j==k||k==i){
                        continue;
                    }
                    if(arr[i]==0){
                        continue;
                    }
                    if(arr[k]%2==0){
                        set.add(arr[i]*100+arr[j]*10+arr[k]);
                    }
                }
            }
        }
        return set.size();
    }
}