class Solution 
{ 
	static int maxCandy(int h[], int n) 
	{ 
        int ptr1 = 0, ptr2 = n-1;
        int maxArea = 0;
        while(ptr1<ptr2){
            int curr = Math.min(h[ptr1],h[ptr2])*(ptr2-ptr1-1);
            maxArea = Math.max(maxArea,curr);
            if(h[ptr1]<h[ptr2])
                ptr1++;
            else ptr2--;
            
        }
        return maxArea;
	}
}
