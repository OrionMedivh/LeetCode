
public class PlusOne {
	// public static int[] plusOne(int[] digits) {
	// if (digits.length==1){
	// if (digits[0]==9){
	// int[] newDigits=new int[2];
	// newDigits[0]=1;
	// newDigits[1]=0;
	// return newDigits;
	// }
	// else {
	// digits[0]++;
	// return digits;
	// }
	// }
	// int[] subDigits= new int[digits.length-1];
	// for (int i=1;i<digits.length;i++) subDigits[i-1]=digits[i];
	// int[] SubResult=plusOne(subDigits);
	// if (SubResult.length==digits.length) { // jin wei.
	// if (digits[0]==9){ // zai jin wei.
	// int[] Result=new int[digits.length+1];
	// Result[0]=1;
	// Result[1]=0;
	// for (int i=2;i<Result.length;i++) Result[i]=SubResult[i-1];
	// return Result;
	// } else {//mei jin wei
	// SubResult[0]+=digits[0];
	// return SubResult;
	// }
	// }else { // mei jin wei
	// for (int i=1;i<digits.length;i++)
	// digits[i]=SubResult[i-1];
	// return digits;
	// }
	// } // bad implementation;

	// public int[] plusOne(int[] digits) {
	// Stack<Integer> stack=new Stack<Integer>();
	// int pass=1;
	// for (int i=digits.length-1;i>=0;i--){
	// int result=digits[i]+pass;
	// stack.push(result%10);
	// pass=result/10;
	// }
	// if (pass==1) stack.push(pass);
	// int[] res=new int[stack.size()];
	// int index=0;
	// while(!stack.isEmpty()){
	// res[index]=stack.pop();
	// index++;
	// }
	// return res;
	// } //iteration

	// public int[] plusOne(int[] digits) {
	// if (plusOne(digits, 0) == 0){
	// return digits;
	// }
	// int[] digits2=new int[digits.length+1];
	// digits2[0] = 1;
	// return digits2;
	// }
	//
	// private int plusOne(int[] digits, int index){
	// int res=0;
	// if (index == digits.length-1){
	// res = (digits[index] + 1)/10;
	// digits[index] = (digits[index]+1)%10;
	// return res;
	// }
	// int nextRes = plusOne(digits, index+1);
	// res = (digits[index]+ nextRes)/10;
	// digits[index] = (digits[index] + nextRes)%10;
	// return res;
	// } // recursive;

	public int[] plusOne(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int[] res = new int[n + 1];
		res[0] = 1;
		return res;
	} // optimal

	public static void main(String args[]) {
		int[] input = { 2, 4, 9, 3, 9 };
		PlusOne s = new PlusOne();
		System.out.println(s.plusOne(input));
	}
}