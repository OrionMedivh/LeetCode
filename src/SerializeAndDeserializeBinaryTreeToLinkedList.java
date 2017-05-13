import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTreeToLinkedList {
	public LinkedList<Integer> serialize(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		serialize(root, result);
		return result;
	}

	private void serialize(TreeNode node, LinkedList<Integer> list) {
		if (node == null) {
			list.add(null);
		}
		list.add(node.val);
		serialize(node.left, list);
		serialize(node.right, list);
	}

	private int index;

	public TreeNode deserialize(LinkedList<Integer> list) {
		index = 0;
		return deserializeHelper(list);
	}

	private TreeNode deserializeHelper(LinkedList<Integer> list) {
		if (list.get(index) == null) {
			return null;
		}
		TreeNode newNode = new TreeNode(list.get(index));
		index++;
		newNode.left = deserializeHelper(list);
		newNode.right = deserializeHelper(list);
		return newNode;
	}
}
