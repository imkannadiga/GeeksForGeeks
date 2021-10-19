class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        Stack<Integer> stack = new Stack<>();
        long max_area = 0;
        int i = 0;
        long area_ = 0;
        int top = 0;
        while(i<n){
            if(stack.isEmpty() || hist[stack.peek()]<=hist[i]){
                stack.push(i++);
            }
            else{
                top = stack.pop();
                area_ = hist[top]*(stack.isEmpty() ? i : i-stack.peek()-1);
                if(area_>max_area)
                    max_area = area_;
            }
        }
        
        while(!stack.isEmpty()){
            top = stack.pop();
            area_ = hist[top] * (stack.isEmpty()?i:i-stack.peek()-1);
            if(area_>max_area)
                max_area = area_;
        }
        return max_area;
    }
}
