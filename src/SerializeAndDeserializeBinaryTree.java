
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
