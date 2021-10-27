class Solution 
{ 
    int count(int N, int A[], int X) 
    {   
        int com=0,ans=N;
        for(int i=30;i>=0;i--){
            if(((X>>i)&1)!=0){
                com^=(1l<<i);
                continue;
            }
            int ct=0;
            long p=com^(1l<<i);
            for(int j=0;j<N;j++){
                if((A[j]&p)==p)
                    ct++;
            }
            ans=Math.min(ans,N-ct);
        }
        return ans;
    }
}