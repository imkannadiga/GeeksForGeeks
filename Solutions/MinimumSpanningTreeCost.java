class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        int[][] graph = genAdjList(V,adj);
        int parent[] = new int[V];
 
        int key[] = new int[V];
 
        Boolean mstSet[] = new Boolean[V];
 
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
 
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            
            int u = minKey(V,key, mstSet);
 
            mstSet[u] = true;
 
            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }
        int cost = 0;
        for(int i=1;i<V;i++){
            cost+=graph[i][parent[i]];
        }
        return cost;
    }
    
    private static int minKey(int V, int key[], Boolean mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        return min_index;
    }
    
    private static int[][] genAdjList(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        int[][] adj_array = new int[V][V];
        for(int i=0;i<V;i++){
            ArrayList<ArrayList<Integer>> curr = adj.get(i);
            for(int j=0;j<curr.size();j++){
                ArrayList<Integer> temp = curr.get(j);
                adj_array[i][temp.get(0)] = temp.get(1);
            }
        }
        return adj_array;
    }
    
}
