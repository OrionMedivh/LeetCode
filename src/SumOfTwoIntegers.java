
//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

public class SumOfTwoIntegers {
	// basic idea:
	// 'exclusive or' has the attribute that it is the sum without carries
	// and we can find carries by (a & b) << 1;
	// so the problem a + b is equivalent to
	// a ^ b + ( a & b ) << 1
	// since it's a sum again, implying it's a loop.
	// we only need to find the condition to
	// exit the loop, either by iteration or recursion.

	public int getSumIterative(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		return a;
	}

	public int getSumRecursive(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getSumRecursive(a ^ b, (a & b) << 1);
	}

	// for subtraction:
	// 'exclusive or' has the meaning of subtraction without borrows
	// and we can find borrows by (~a & b) << 1;
	// because we need to borrow only when current digit in a is 0 and b is 1
	// so we can get a similar equation: a - b <==> a ^ b - (~a & b) << 1

	public int getSubtractIterative(int a, int b) {
		while (b != 0) {
			int borrow = ~a & b;
			a = a ^ b;
			b = borrow << 1;
		}
		return a;
	}

	public int getSubtractRecursive(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getSubtractRecursive(a ^ b, (~a & b) << 1);
	}

	// An alternative to calculate subtraction is to sum the negative of second
	// integer
	public int negate(int x) {
		return ~x + 1;
	}

	public int getSubtractAlternative(int a, int b) {
		return getSumRecursive(a, negate(b));
	}

	public static void main(String[] args) {
		SumOfTwoIntegers s = new SumOfTwoIntegers();
		System.out.println(s.getSumIterative(4, 5));
		System.out.println(s.getSumRecursive(4, 5));
		System.out.println(s.getSubtractIterative(4, 5));
		System.out.println(s.getSubtractRecursive(4, 5));
		System.out.println(s.getSubtractAlternative(4, 5));
	}
}
