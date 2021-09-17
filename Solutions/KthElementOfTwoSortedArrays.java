class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int i=0,j=0;
        int elem = 0;
        while((i+j)<k){
            if(i>=n){
                elem = arr2[j+(k-(i+j)-1)];
                break;
            }
            if(j>=m){
                elem = arr1[i+(k-(i+j)-1)];
                break;
            }
            if(arr1[i]<arr2[j]){
                elem = arr1[i];
                i++;
            }
            else{
                elem = arr2[j];
                j++;
            }
        }
        return (long)elem;
    }
}