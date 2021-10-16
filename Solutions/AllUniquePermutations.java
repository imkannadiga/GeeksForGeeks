class Solution {
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static ArrayList<Integer> curr = new ArrayList<Integer>();
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Boolean> vis = new ArrayList<Boolean>();
    
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> nums , int n) {
        Collections.sort(nums);
        arr = new ArrayList<Integer>();
        curr = new ArrayList<Integer>();
        ans = new ArrayList<ArrayList<Integer>>();
        vis = new ArrayList<Boolean>();
        for(Integer i : nums){
            arr.add(i);
            vis.add(false);
        }
        recurse();
        return ans;
    }
    
    private static void recurse(){
        if(curr.size()==arr.size()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<(int)arr.size();i++){
            if(vis.get(i)==true) continue;
            if (i > 0 && (arr.get(i) == arr.get(i - 1)) && !vis.get(i - 1))
                continue;
            vis.set(i,true);
            curr.add(arr.get(i));
            recurse();
            vis.set(i,false);
            curr.remove(curr.size()-1);
        }
    }
};