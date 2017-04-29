import java.util.HashMap;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
    	if (denominator == 0) return "Nan";
    	if (numerator == 0) return "0";
    	StringBuffer sb = new StringBuffer();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        boolean sign = (numerator>=0) == (denominator>0) ?true:false;
        long numerator1 = Math.abs((long)numerator);
        long denominator1 = Math.abs((long)denominator);
        long remainder = numerator1%denominator1;
        long integer =numerator1 / denominator1;
        int index=0;
        if(remainder ==0){
        	return (sign?"":"-")+integer;
        }
    	while(remainder != 0 && !map.containsKey(remainder)){
        	map.put(remainder, index++);
        	remainder *= 10;
        	sb.append(remainder / denominator1);
        	remainder %= denominator1;
        }
        
        if(remainder == 0){ 
        	return (sign?"":"-")+integer+'.'+sb.toString();
        }else{
        	return (sign?"":"-")+integer+'.'+sb.substring(0, map.get(remainder))+"("+sb.substring(map.get(remainder),index)+")";
        }
    }
    
    public static void main(String[] args){
    	FractionToRecurringDecimal s = new FractionToRecurringDecimal();
    	System.out.println(s.fractionToDecimal(-2147483648, 1));
    	System.out.println(s.fractionToDecimal(10, 8));
    	System.out.println(s.fractionToDecimal(1, -9));
    }
}