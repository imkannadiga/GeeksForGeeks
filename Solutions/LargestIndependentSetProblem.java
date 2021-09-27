class Solution {
    public int LISS(Node node){
        if(node==null)
            return 0;
        int excl = LISS(node.left)+LISS(node.right);
        
        int incl = 1;
        if(node.left!=null)
            incl+=LISS(node.left.left)+LISS(node.left.right);
        if(node.right!=null)
            incl+=LISS(node.right.left)+LISS(node.right.right);
        return Math.max(excl,incl);
    }
}