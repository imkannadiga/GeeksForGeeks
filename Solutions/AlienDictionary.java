class Solution
{
    
    class Graph{
        LinkedList<Integer>[] adj;
        Graph(int n){
            adj = new LinkedList[n];
            for(int i=0;i<n;i++)
                adj[i] = new LinkedList<>();
        }
        void addEdge(int a, int b){
            adj[a].add(b);
        }
        int getLength(){
            return adj.length;
        }
        String sort(){
            int n = getLength();
            Stack<Integer> stk = new Stack<>();
            boolean[] vis = new boolean[n];
            for(int i=0;i<n;i++){
                if(!vis[i])
                    helper(i,vis,stk);
            }
            StringBuilder sb = new StringBuilder();
            while(!stk.isEmpty())
                sb.append(stk.pop()+'a');
            return sb.toString();
        }
        private void helper(int i, boolean[] vis, Stack<Integer> stk){
            vis[i]=true;
            for(int x : adj[i]){
                if(!vis[x])
                    helper(x,vis,stk);
            }
            stk.push(i);
        }
    }
    public String findOrder(String [] dict, int N, int K)
    {
        Graph g = new Graph(K);
        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            for(int j=0;((j<s1.length())&&(j<s2.length()));j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    g.addEdge(s1.charAt(j)-'a',s2.charAt(j)-'a');
                    break;
                }
            }
        }
        return g.sort();
    }
}
