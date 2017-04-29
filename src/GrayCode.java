import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        for (int i = 0; i< n; i++){
            for(int j= result.size()-1; j>=0; j--){
                result.add(result.get(j)+(1<<i));
            }
        }
        return result;
    }
}