import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision
{
  //equations = [ ["a", "b"], ["b", "c"] ],
  //values = [2.0, 3.0],
  //queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
//  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//    HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>(); //"b" -> {"a","c"}
//    HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();//"b" -> {0.5,3.0}
//    for (int i = 0; i < equations.length; i++) {
//        String[] equation = equations[i];
//        if (!pairs.containsKey(equation[0])) { //"a" -> {}
//            pairs.put(equation[0], new ArrayList<String>());
//            valuesPair.put(equation[0], new ArrayList<Double>());
//        }
//        if (!pairs.containsKey(equation[1])) { //"b" -> {}
//            pairs.put(equation[1], new ArrayList<String>());
//            valuesPair.put(equation[1], new ArrayList<Double>());
//        }
//        pairs.get(equation[0]).add(equation[1]); //"a" -> {"b"}
//        pairs.get(equation[1]).add(equation[0]); //"b" -> {"a"}
//        valuesPair.get(equation[0]).add(values[i]); //"a" -> {2.0}
//        valuesPair.get(equation[1]).add(1/values[i]); //"b" -> {0.5}
//    }
//    
//    double[] result = new double[queries.length];
//    for (int i = 0; i < queries.length; i++) {
//        String[] query = queries[i];
//        result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
//        if (result[i] == 0.0) result[i] = -1.0;
//    }
//    return result;
//}
//
//private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
//    //start, end, calculated pairs, calculated values, points already visited, transition value
//  
//    if (set.contains(start)) return 0.0; //if already visited, means it's a loop, skip.
//    if (!pairs.containsKey(start)) return 0.0; //start was never in the input, skip.
//    if (start.equals(end)) return value; //if find the one we're looking for, return value.
//    set.add(start);
//    
//    ArrayList<String> strList = pairs.get(start);
//    ArrayList<Double> valueList = values.get(start);
//    double tmp = 0.0;
//    for (int i = 0; i < strList.size(); i++) {
//        tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
//        if (tmp != 0.0) {
//            break;
//        }
//    }
//    set.remove(start);
//    return tmp;
//} // this code is rubbish

  public double[] calcEquation( String[][] equations, double[] values, String[][] queries )
  {

    HashMap<String, Node> map = new HashMap<>();

    for ( int i = 0; i < values.length; i++ )
    {
      String v1 = equations[i][0];
      String v2 = equations[i][1];

      if ( !map.containsKey( v1 ) )
        map.put( v1, new Node() );

      if ( !map.containsKey( v2 ) )
        map.put( v2, new Node() );

      Node n1 = map.get( v1 );
      Node n2 = map.get( v2 );

      n1.neighbors.add( n2 );
      n1.values.add( values[i] );

      n2.neighbors.add( n1 );
      n2.values.add( 1.0 / values[i] );
    }

    double[] res = new double[queries.length];

    for ( int i = 0; i < res.length; i++ )
    {
      String v1 = queries[i][0];
      String v2 = queries[i][1];

      if ( !map.containsKey( v1 ) || !map.containsKey( v2 ) )
        res[i] = -1.0;
      else
        res[i] = dfs( map.get( v1 ), map.get( v2 ), new HashSet<Node>() );
    }

    return res;
  }

  double dfs( Node cur, Node dest, HashSet<Node> visited )
  {

    if ( cur == dest )
      return 1;

    if ( visited.contains( cur ) )
      return -1;

    visited.add( cur );

    for ( int i = 0; i < cur.neighbors.size(); i++ )
    {
      double pathval = dfs( cur.neighbors.get( i ), dest, visited );

      if ( pathval > 0 )
        return cur.values.get( i ) * pathval;
    }

    return -1;
  }
}

class Node
{

  List<Node> neighbors = new ArrayList<>();
  List<Double> values = new ArrayList<>();
}
