class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
        n++;
        int count = n/2;
        int pow = 2;
        while(pow<=n){
            int curr = n/pow;
            count += (curr/2)*pow;
            count += (curr%2==1)?(n%pow):0;
            pow <<=1;
        }
        return count;
    }
}
