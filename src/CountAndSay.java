public class CountAndSay {
    public static String countAndSay(int n) {
        if (n==1) return Integer.toString(1);
        String input=countAndSay(n-1);
        int count=1;
        StringBuffer result=new StringBuffer();
        int digits=input.length();
        for (int i=1;i<digits;i++){
            if (input.charAt(i)!=input.charAt(i-1)){
                result.append(Integer.toString(count));
                result.append(input.charAt(i-1));
                count=1;
            }else{
                count++;
            }
        }
        //after termination:
        result.append(Integer.toString(count));
        result.append(input.charAt(input.length()-1));
        return result.toString(); 
    }
    
    public static void main(String[] args){
    	System.out.println(countAndSay(2));
    }
}