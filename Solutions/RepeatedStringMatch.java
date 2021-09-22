class Solution 
{ 
	static int repeatedStringMatch(String A, String B) 
	{
	    int ans = 1;
	    String temp = A;
	    while(temp.length()<B.length()){
	        temp+=A;
	        ans++;
	    }
	    if(temp.contains(B))
	        return ans;
	    if((temp+A).contains(B))
	        return ans+1;
	    return -1;
	} 
} 