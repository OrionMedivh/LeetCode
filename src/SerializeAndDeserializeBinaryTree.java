
/*
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, or transmitted across a network connection 
link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how 
your serialization/deserialization algorithm should work. You just need to ensure that a binary 
tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not 
necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and 
deserialize algorithms should be stateless.
 */

public class SerializeAndDeserializeBinaryTree {

	private int index;

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		PreorderTraverse(sb, root);
		return sb.toString();
	}

	private void PreorderTraverse(StringBuffer sb, TreeNode node) {
		if (node == null) {
			sb.append("null,");
		} else {
			sb.append(node.val + ",");
			PreorderTraverse(sb, node.left);
			PreorderTraverse(sb, node.right);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] values = data.split(",");
		index = 0;
		return BuildTree(values);
	}

	private TreeNode BuildTree(String[] values) {
		if (index >= values.length) {
			return null;
		}
		if (values[index].equals("null")) {
			index++;
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(values[index]));
		index++;
		node.left = BuildTree(values);
		node.right = BuildTree(values);
		return node;
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
}
