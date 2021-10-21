class Solution
{
	Node lca(Node root, int n1,int n2)
	{
		Node node = root;
		List<Node> path1 = new LinkedList<>();
		List<Node> path2 = new LinkedList<>();
		
		if(!getPath(root,n1,path1) || !getPath(root,n2,path2)) return root;
		
		int i;
		for(i=0; (i<path1.size()) && (i<path2.size()); i++){
		    if(!path1.get(i).equals(path2.get(i)))
		        break;
		}
		return path1.get(i-1);
	}
	
	boolean getPath(Node curr, int n, List<Node> path){
	   if(curr==null) return false;
	   path.add(curr);
	   if(curr.data==n) return true;
	   if(curr.left!=null && getPath(curr.left,n,path))
	       return true;
	   if(curr.right!=null && getPath(curr.right,n,path))
	       return true;
	   path.remove(path.size()-1);
	   return false;
	    
	}
}