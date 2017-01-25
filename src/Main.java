import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// int[][] a= new int[][]{{0,1},{0,2},{1,2},
		// //{2,3},
		// {2,4}};
		// NumberOfConnectedComponentsInAnUndirectedGraph s = new
		// NumberOfConnectedComponentsInAnUndirectedGraph();
		// System.out.println(s.countComponents(5, a));

		// ListNode head = new ListNode(1);
		// head.next = new ListNode(2);
		// head.next.next = new ListNode(3);
		// LinkedListRandomNode obj = new LinkedListRandomNode(head);
		// System.out.println(obj.getRandom());
		// System.out.println(obj.getRandom());
		// System.out.println(obj.getRandom());
		// System.out.println(obj.getRandom());

		// FlipGameII s = new FlipGameII();
		// System.out.println(s.canWin("--"));
		// System.out.println(s.canWin("+++-"));
		// System.out.println(s.canWin("+--+"));
		// System.out.println(s.canWin(""));
		// System.out.println(s.canWin("+"));
		// System.out.println(s.canWin("++"));
		// System.out.println(s.canWin("+++"));
		// System.out.println(s.canWin("++++"));
		// System.out.println(s.canWin("+++++"));
		// System.out.println(s.canWin("++++++"));
		// System.out.println(s.canWin("+++++++"));
		// System.out.println(s.canWin("++++++++"));
		// System.out.println(s.canWin("+++++++++"));

		// GeneralizedAbbreviation s = new GeneralizedAbbreviation();
		// System.out.println(s.generateAbbreviations("word"));

		// SortTransformedArray s = new SortTransformedArray();
		// System.out.println(Arrays.toString(s.sortTransformedArray(new int[] {
		// -4, -2, 2, 4 }, -1, 3, 5)));

		// KthSmallestElementInBST s = new KthSmallestElementInBST();
		// TreeNode root = new TreeNode(8);
		// root.left = new TreeNode(3);
		// root.left.left = new TreeNode(1);
		// root.left.right = new TreeNode(6);
		// root.left.right.left = new TreeNode(4);
		// root.right = new TreeNode(10);
		// System.out.println(s.kthSmallest(root, 3));

		// BinaryTreeLongestConsecutiveSequence s = new
		// BinaryTreeLongestConsecutiveSequence();
		// TreeNode node1 = new TreeNode(1);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node5 = new TreeNode(5);
		// node1.right = node3;
		// node3.left = node2;
		// node3.right = node4;
		// node4.right = node5;
		// System.out.println(s.longestConsecutive(node1));

		// TreeNode root = new TreeNode(1);
		// BSTIterator i = new BSTIterator(root);
		// while (i.hasNext()) System.out.println(i.next());

		// VerifyPreorderSerializationofaBinaryTree s = new
		// VerifyPreorderSerializationofaBinaryTree();
		// System.out.println(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		// System.out.println(s.isValidSerialization("1,#,#,1"));
		// System.out.println(s.isValidSerialization("1"));

		// HIndex s = new HIndex();
		// System.out.println(s.hIndex(new int[] { 3, 0, 6, 1, 5 }));

		// MinimumHeightTrees s = new MinimumHeightTrees();
		// System.out.println(s.findMinHeightTrees(4, new int[][] { { 1, 0 },
		// { 1, 2 }, { 1, 3 } }));

//		NextPermutation s = new NextPermutation();
//		// int[] nums= new int[]{5,1,4,3,2};
//		int[] nums = new int[] { 1, 1 };
//		s.nextPermutation(nums);
//		System.out.println(Arrays.toString(nums));
	  
	    MagicalString s = new MagicalString();
//	    System.out.println( s.magicalString( -1 ) );
//	    System.out.println( s.magicalString( 0 ) );
//	    System.out.println( s.magicalString( 1 ) );
//	    System.out.println( s.magicalString( 2 ) );
//	    System.out.println( s.magicalString( 6 ) );
//	    System.out.println( s.magicalString( 8 ) );
	    System.out.println( s.magicalString( 10 ) );
	}
}
