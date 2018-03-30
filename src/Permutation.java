
/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	// public ArrayList<ArrayList<Integer>> permute(int[] num) {
	// return permute1(num, num.length-1);
	// }
	//
	// public static ArrayList<ArrayList<Integer>> permute1(int[] num, int
	// index)
	// {
	// ArrayList<ArrayList<Integer>> result= new
	// ArrayList<ArrayList<Integer>>();
	// if (index==0){// 1 left in the array.
	// ArrayList<Integer> subArray= new ArrayList<Integer>();
	// subArray.add(num[0]);
	// result.add(subArray);
	// return result;
	// }
	// ArrayList<ArrayList<Integer>> subPermute=permute1(num, index-1);
	// for (ArrayList<Integer> i:subPermute){
	// for (int j=0;j<=i.size();j++){
	// ArrayList<Integer> sub=new ArrayList<Integer>();
	// for (int k=0;k<j;k++){
	// sub.add(i.get(k));
	// }
	// sub.add(num[index]);
	// for (int k=j;k<i.size();k++){
	// sub.add(i.get(k));
	// }
	// result.add(sub);
	// }
	// }
	// return result;
	// }

	// public ArrayList<ArrayList<Integer>> permute(int[] num) {
	// ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	// if (num.length==0) return result;
	// ArrayList<Integer> list=new ArrayList<Integer>();
	// list.add(num[0]);
	// result.add(list);
	// ArrayList<ArrayList<Integer>> listlist=new
	// ArrayList<ArrayList<Integer>>();
	// for (int index=1;index<num.length;index++){
	// for (ArrayList<Integer> i:result){
	// for (int j=0;j<=i.size();j++){
	// ArrayList<Integer> list1=new ArrayList<Integer>();
	// for (int k=0;k<j;k++) {
	// list1.add(i.get(k));
	// }
	// list1.add(num[index]);
	// for (int k=j;k<i.size();k++){
	// list1.add(i.get(k));
	// }
	// listlist.add(list1);
	// }
	// }
	// result=listlist;
	// listlist=new ArrayList<ArrayList<Integer>>();
	// }
	// return result;
	// }

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permute(nums, 0, list);
		return list;
	}

	private void permute(int[] nums, int pos, List<List<Integer>> list) {
		if (pos >= nums.length - 1) {
			// >= nums.length yield to same result, but with some unnecessary
			// swap
			ArrayList<Integer> res = new ArrayList<Integer>();
			for (int i : nums) {
				res.add(i);
			}
			list.add(res);
		} else {
			for (int i = pos; i < nums.length; i++) {
				swap(nums, i, pos);
				permute(nums, pos + 1, list); 
				// from pos + 1, because permutation is n * n-1 * n-2 * ...
				// a.k.a n!. 
				swap(nums, i, pos);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String args[]) {
		Permutation s = new Permutation();
		int[] num = new int[] { 6, 2, -1, 8 };
		System.out.println(s.permute(num));
	}
}