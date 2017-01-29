
public class NthDigit {

    public int findNthDigit(int n) {
        long count = 9;
        int size = 1;
        
        while(n > count * size ){ // n = 11
            n -= count * size; // 11 - 9 = 2
            size++; // 2
            count *= 10; // 90
        }
        //size = 2, count = 90, n = 2
        
        long first = count / 9; // 10
        
        first += (n-1)/size; // get the number itself, here is '10'
        String s = Long.toString(first);
        //String s = first + "";
        return Character.getNumericValue(s.charAt((n-1)%size));
    }
    
	public static void main(String[] args) {
		NthDigit s = new NthDigit();
		System.out.println(s.findNthDigit(11));
	}

}
