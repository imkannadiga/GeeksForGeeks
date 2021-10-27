class Solution
{
    String convert(String s, int numRows)
    {
        int n = s.length();
        if(numRows<=1 || numRows>n){
            return s;
        }
        int interval = 2*numRows-2;
        char[] arr = new char[n];
        int count =0;
        for(int i = 0;i< numRows;i++){
            int step = interval-2*i;
            for(int j = i;j< n;j+=interval){
                arr[count++] = s.charAt(j);
                if(step >0 && step < interval && j+step<n){
                    arr[count++] = s.charAt(j+step);
                }
            }
        }
        
        return String.valueOf(arr);
    }
}