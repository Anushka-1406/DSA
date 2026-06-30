/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer , Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length ; i++){
            hm.put(inorder[i],i);
        }
        return build(preorder , 0 ,preorder.length - 1, inorder, 0 , inorder.length-1,hm );
    }
    private TreeNode build(int[] preorder , int prestart , int preend , int[] inorder , int instart , int inend , Map<Integer,Integer> hm){
        if(prestart > preend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inroot = hm.get(root.val);
        int numsleft = inroot - instart;

        root.left = build(preorder , prestart+1 , prestart+numsleft , inorder,instart,inroot-1 , hm);
        root.right = build(preorder , prestart+numsleft+1 , preend,inorder,inroot+1,inend , hm);

        return root;
    }
}