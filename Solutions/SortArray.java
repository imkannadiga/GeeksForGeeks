class Solution
{
    public static void sort012(int a[], int n)
    {
        int[] arr = new int[3];
        for(int i : a)
            arr[i]++;
        int j=0; 
        for(int i=0;i<3;i++){
            while(arr[i]>0){
                a[j++] = i;
                arr[i]--;
            }
        }
        return;
    }
}