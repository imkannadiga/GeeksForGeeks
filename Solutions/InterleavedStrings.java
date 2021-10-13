class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
	    int M = a.length();
	    int N = b.length();
	    if((M+N)!=c.length()) return false;
	    boolean[][] dp = new boolean[M+1][N+1];
	    for(int i=0;i<=M;i++){
	        for(int j=0;j<=N;j++){
	            if(i==0 && j==0){
	                dp[i][j] = true;
	            }
	            else if(i==0){
	                if(b.charAt(j-1)==c.charAt(j-1)){
	                    dp[i][j]=dp[i][j-1];
	                }
	            }
	            else if(j==0){
	                if(a.charAt(i-1)==c.charAt(i-1)){
	                    dp[i][j]=dp[i-1][j];
	                }
	            }
	            else if(b.charAt(j-1)!=c.charAt(i+j-1) && a.charAt(i-1)==c.charAt(i+j-1)){
	                dp[i][j] = dp[i-1][j];
	            }
	            else if(b.charAt(j-1)==c.charAt(i+j-1) && a.charAt(i-1)!=c.charAt(i+j-1)){
	                dp[i][j] = dp[i][j-1];
	            }
	            else if(a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)){
	                dp[i][j] = (dp[i-1][j] || dp[i][j-1]);
	            }
	        }
	    }
	    return dp[M][N];
	}
}