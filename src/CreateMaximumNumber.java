import java.util.Arrays;


public class CreateMaximumNumber {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] result = new int[k];
		int size1 = nums1.length, size2 = nums2.length;
		if (k == 0 || k > size1 + size2)
			return result;
		for (int i = Math.min(size1, k); i >= Math.max(k - size2, 0); i--) {
			int[] sub1 = new int[i];
			int[] sub2 = new int[k - i];
			findMax(nums1, sub1, 0, 0);
			findMax(nums2, sub2, 0, 0);
			int[] merge = merge(sub1, sub2);
			if (compare(merge, result, 0))
				result = merge;
		}
		return result;

	}

	public void findMax(int[] num, int[] sub, int index, int subIndex) {
		if (subIndex == sub.length) return;
		if (index == num.length) return;
		if (num.length - index == sub.length - subIndex) {
			for (int i = 0; i < num.length - index; i++) {
				sub[i+subIndex] = num[i+index];
			}
			return;
		}
		int max = -1, ind = 0;
		for (int i = index; i <= num.length - sub.length + subIndex; i++) {
			if (num[i] > max) {
				max = num[i];
				ind = i;
			}
		}
		sub[subIndex]=max;
		findMax(num, sub, ind + 1, subIndex + 1);
	}

	public int[] merge(int[] array1, int[] array2) {
		int size1 = array1.length, size2 = array2.length;
		int[] result = new int[size1 + size2];
		int i = 0, j = 0;
		while (i != size1 && j != size2) {
			if (array1[i] > array2[j]) {
				result[i + j] = array1[i];
				i++;
			} else if(array1[i] < array2[j]) {
				result[i + j] = array2[j];
				j++;
			} else {
				result[i + j] = array1[i];
				int p=i+1,q=j+1;
				while(p != size1 && q!=size2 && array1[p]==array2[q]){p++;q++;}
				if ( p == size1) j++;
				else if(q == size2) i++;
				else if( array1[p] > array2[q])
					i++;
				else j++;
			}
		}
		if (i == size1)
			while (j != size2) {
				result[i + j] = array2[j];
				j++;
			}
		else
			while (i != size1) {
				result[i + j] = array1[i];
				i++;
			}
		return result;
	}

	public boolean compare(int[] array1, int[] array2, int index) {
		if (index == array1.length) {
			return true;
		}
		if(array1[index] > array2[index]) return true;
		if(array1[index] < array2[index]) return false;
		return compare(array1, array2, index+1);
	}
	
	public static void main(String[] args){
		CreateMaximumNumber s = new CreateMaximumNumber();
		System.out.println(s.compare(new int[]{1,2,3,4,5},new int[]{1,2,3,4,4},0));
		System.out.println(Arrays.toString(s.merge(new int[]{7,3,8,0,6,5,7,4,2}, new int[]{2,5,6,4,4,0})));
		System.out.println(Arrays.toString(s.merge(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,4,2})));
		int[] sub = new int[3];
		s.findMax(new int[]{9,1,2,5,8,3}, sub, 0, 0);
		System.out.println(Arrays.toString(sub));
		System.out.println(Arrays.toString(s.maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5)));
		System.out.println(Arrays.toString(s.maxNumber(new int[]{6,7}, new int[]{6,0,4}, 5)));
		System.out.println(Arrays.toString(s.maxNumber(new int[]{3,9}, new int[]{8,9}, 3)));
		System.out.println(Arrays.toString(s.maxNumber(new int[]{2,5,6,4,4,0}, new int[]{7,3,8,0,6,5,7,4,2}, 15)));
		System.out.println(Arrays.toString(s.maxNumber(new int[]{2,8,0,4,5,1,4,8,9,9,0,8,2,9}, new int[]{5,9,6,6,4,1,0,7}, 22)));
		System.out.println(Arrays.toString(s.maxNumber(new int[]{5,9,6,6,4,1,0,7}, new int[]{2,8,0,4,5,1,4,8,9,9,0,8,2,9},  22)));
		System.out.println(Arrays.toString(s.maxNumber(new int[]{5,0,2,1,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3}, new int[]{7,6,7,1,0,1,0,5,6,0,5,0},  31)));	
		System.out.println(Arrays.toString(s.maxNumber(new int[]{7,6,7,1,0,1,0,5,6,0,5,0}, new int[]{5,0,2,1,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3},  31)));	
	}
}