public class UniquePath {
    public int uniquePaths(int m, int n) {
        if (m<=0 || n<=0) return 0;
        if (m==1 && n==1) return 1;
        int[] line=new int[m];
        for (int i=0;i<m;i++){
        	line[i]=1;
        }
        for (int i=1;i<n;i++){ // line[0] is always 1. so don't change it.
        	for (int j=1;j<m;j++){
        		line[j]=line[j]+line[j-1];
        	}
        }
        return line[m-1];
    }
}