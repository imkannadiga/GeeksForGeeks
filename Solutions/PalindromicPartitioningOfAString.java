class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        solve(S,res,new ArrayList<String>());
        return res;
    }
    
    static void solve(String s, ArrayList<ArrayList<String>> res, ArrayList<String> curr){
        if(s.length()==0){
            res.add(new ArrayList<String>(curr));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String temp = s.substring(0,i);
            if(isPalindrome(temp)){
                curr.add(temp);
                solve(s.substring(i),res,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    static boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<s.length() && j>=0){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}