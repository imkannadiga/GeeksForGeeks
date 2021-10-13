class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
        long count = 0;
        for(int i=0;i<n;i++){
            long curr = arr[i];
            int l=i+1, r=n-1;
            while(l<r){
                curr+=arr[l]+arr[r];
                if(curr>=sum) r = r-1;
                else{
                    count+=(r-l);
                    l++;
                }
                curr = arr[i];
            }
        }
        return count;
    }
}