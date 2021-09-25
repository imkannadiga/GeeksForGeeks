class GfG
{
    int maxLen(int arr[], int n)
    {
        int maxLen = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(arr[i]==0 && maxLen==0)
                maxLen = 1;
            if(sum==0)
                maxLen = i+1;
            Integer lasti = map.get(sum);
            if(lasti!=null){
                maxLen = Math.max(maxLen,i-lasti);
            }
            else
                map.put(sum,i);
        }
        return maxLen;
    }
}