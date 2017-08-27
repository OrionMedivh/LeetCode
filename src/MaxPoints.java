
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class MaxPoints {
	double epsilon=0.0001;
    public int maxPoints(Point[] points) {
    	if (points.length<3)
    		return points.length;
    	else{
    		Point[] bucket=new Point[points.length];
    		int[] count=new int[points.length];
    		int bucketSize=1;
    		bucket[0]=points[0];
    		count[0]=1;
    		for (int i=1;i<points.length;i++)
    		{	
    			boolean match=false;
    			for (int j=0;j<bucketSize;j++){
    				if (!((bucket[j].x==points[i].x) && (bucket[j].y==points[i].y))){
    				}
    				else{
    					match=true;
    					count[j]++;
    					}
    			}
				if (match==false){
				bucket[bucketSize]=points[i];
				count[bucketSize]=1;
				bucketSize++;
				}
    		}	
        	if (bucketSize<3)
        		return points.length;
        	else{
    	int Max=2;//max number for all lines, at least 2.
    	
        for (int i=0;i<bucketSize;i++){
        	for (int j=i+1;j<bucketSize;j++){
        		MyLine myline=new MyLine();
        		int max=count[i]+count[j];//max number for one line.
        		if (bucket[i].x-bucket[j].x==0){
        			myline=new MyLine(1,0,-bucket[i].x);//x=x1 => 1x+0y+(-x1)=0;
        		}
        		else {
        			double slope=((double)(bucket[i].y-bucket[j].y))/(bucket[i].x-bucket[j].x);
        			myline=new MyLine(-slope,1,slope*bucket[i].x-bucket[i].y);//(-a/b)x+y+(c/b)=0; y1=slope*x1+c; -c=slope*x1-y1;
        		} 
            	for (int k=j+1;k<bucketSize;k++){
            		double result=bucket[k].x*myline.a+bucket[k].y*myline.b+myline.c;
            		boolean judge=(Math.abs(result)<epsilon);
            		if (judge){
            			max+=count[k];
            		}
            	if (max>Max){
            		Max=max;
            	}
        		}
        	}
        } 
    	return Max;
    	}
    	}
    }
    
    public static void main(String[] args){
    MaxPoints sol=new MaxPoints();
    //[(0,9),(138,429),(115,359),(115,359),(-30,-102),(230,709),(-150,-686),(-135,-613),(-60,-248),
    //(-161,-481),(207,639),(23,79),(-230,-691),(-115,-341),(92,289),(60,336),(-105,-467),(135,701),(-90,-394),(-184,-551),(150,774)]
    Point p1=new Point(0,9),p2=new Point(138,429),p3=new Point(115,359),p4=new Point(115,359),p5=new Point(0,-70),p6=new Point(-30,-102),p7=new Point(230,709),
    		p8=new Point(-150,-686),p9=new Point(-135,-613), p10= new Point(-60,-248), p11= new Point(-161,-481), p12= new Point(207,639), p13= new Point(23,79),
    		p14= new Point(-230,-691), p15= new Point(-115,-341), p16= new Point(92,289), p17= new Point(60,336), p18= new Point(-105,-467), 
    		p19= new Point(135,701), p20= new Point(-90,-394), p21= new Point(-184,-551), p22= new Point(150,774);
    Point[] points=new Point[22];
    points[0]=p1;points[1]=p2;points[2]=p3;points[3]=p4;points[4]=p5;points[5]=p6;points[6]=p7;points[7]=p8;points[8]=p9;
    points[9]=p10;points[10]=p11;points[11]=p12;points[12]=p13;points[13]=p14;points[14]=p15;points[15]=p16;points[16]=p17;points[17]=p18;
    points[18]=p19;points[19]=p20;points[20]=p21;points[21]=p22;
    System.out.println(sol.maxPoints(points));
    }
}

	class MyLine{//ax+by+c=0
		double a;
		double b;
		double c;
		MyLine() {
			a=0;
			b=0;
			c=0;
			}
		MyLine(double a, double b, double c){
			this.a=a;
			this.b=b;
			this.c=c;
			}
}