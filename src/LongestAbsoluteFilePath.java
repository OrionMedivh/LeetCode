
public class LongestAbsoluteFilePath {

//    public int lengthLongestPath(String input) {
//        int length = input.length();
//        char[] inputArray = input.toCharArray();
//        int cur =0, max = 0;
//        int[] level = new int[length]; // to save current starting position for each level
//        int curLevel = 0;
//        boolean separator = false;
//        for(int i = 0; i < length; i++ ){
//        	if(inputArray[i] == '\n'){
//        		level[curLevel] = cur+1; //save end index of previous level; + '/' or '\n';
//        		separator = true;
//        		curLevel = 0; // reset current level;
//        		max = Math.max(cur, max);
//        	}else if(inputArray[i] == '\t'){
//        		curLevel++; // see how many levels it'll reach.
//        	}else{
//        		if(separator == true){
//        			if(curLevel<1) return 0;
//        			cur = level[curLevel-1]; //get starting point of current level
//        		}
//        		separator = false;
//        	}
//        	cur++;
//        }
//        max = Math.max(cur, max);
//        return max;
//    } //wrong, bad implementation.
    
	public int lengthLongestPath(String input) {
		String[] array = input.split("\n");
		int[] level = new int[array.length+1]; // to save current starting position for each level
		int max=0;
		for(String s:array){
			int curLevel = s.lastIndexOf('\t')+1; // how many '\t', means which level as well.
			int curLength = level[curLevel+1] = level[curLevel] + s.length() - curLevel + 1; //replace all '\t', add one '/'
			if(s.contains(".")){
				max = Math.max(max, curLength-1); // remove end '/';
			}
		}
        return max;
    }
    
	public static void main(String[] args) {
		LongestAbsoluteFilePath s = new LongestAbsoluteFilePath();
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(s.lengthLongestPath(input));
		input = "dir\n    file.txt";
		System.out.println(s.lengthLongestPath(input));
	}

}
