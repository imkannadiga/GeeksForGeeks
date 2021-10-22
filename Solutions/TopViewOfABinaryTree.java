class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        class QueueObj {
            Node node;
            int hd;
 
            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, Node> topViewMap
            = new TreeMap<Integer, Node>();
 
        if (root == null) {
            return null;
        }
        else {
            q.add(new QueueObj(root, 0));
        }
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }
 
            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,
                                   tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,
                                   tmpNode.hd + 1));
            }
        }
        ArrayList<Integer> out = new ArrayList<>();
        for (Map.Entry<Integer, Node> entry : topViewMap.entrySet())
            out.add(entry.getValue().data);
        return out;
        
    }
}