class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> out = new ArrayList<>();
        for(int i=0;i<k;i++)
            map.put(A[i],map.getOrDefault(A[i],0)+1);
        out.add(map.size());
        for(int i=1;i<n-k+1;i++){
            map.put(A[i+k-1],map.getOrDefault(A[i+k-1],0)+1);
            map.put(A[i-1],map.get(new Integer(A[i-1]))-1);
            if(map.get(A[i-1])==0)
                map.remove(A[i-1]);
            out.add(map.size());
        }
        return out;
    }
}