class Solution
{
    //Function to swap odd and even bits.
    public static int swapBits(int n) 
    {
        int odd = n & 0xAAAAAAAA;
        int even = n & 0x55555555;
        even<<=1;
        odd>>=1;
        return odd|even;
	}
    
}