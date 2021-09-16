class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] meetings = new int[n][2];
        for(int i=0;i<n;i++){
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, new Comparator<int[]>(){
           public int compare(int[] a1, int[] a2){
               return a1[1]-a2[1];
           } 
        });
        int count = 1;
        //for(int[] a : meetings)
            //System.out.println(Arrays.toString(a));
        int[] prev = meetings[0];
        for(int i=1;i<n;i++){
            if(meetings[i][0]>prev[1]){
                prev = meetings[i];
                count++;
            }
        }
        return count;
    }
}