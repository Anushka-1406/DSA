/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder s = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode curNode = q.poll();
            if(curNode == null){
                s.append("#").append(",");
            }
            else{
            s.append(curNode.val).append(",");
            q.offer(curNode.left);
            q.offer(curNode.right);
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int i = 1;

        while(!q.isEmpty() && i < values.length){
            TreeNode node = q.poll();

            if(!values[i].equals("#")){
                TreeNode leftnode = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftnode;
                q.offer(leftnode);
            }
            i++;
            if(!values[i].equals("#")){
                TreeNode rightnode = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightnode;
                q.offer(rightnode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));