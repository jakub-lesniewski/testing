public class Triangle extends Polygon {

	public Triangle(Point[] points) {
		this.points = new Point[3];
		for(int i=0;i<3;i++)
			this.points[i]=points[i];
	}

	public String getTriangleType() {
		return getTriangleSideType()+" "+getTriangleAngelType();
	}

	protected String getTriangleAngelType() {
		double a = Figure.getLength(points[0],points[1]);
		double b = Figure.getLength(points[1],points[2]);
		double c = Figure.getLength(points[2],points[0]);
		double max = c;
		double min1 = a;
		double min2 = b;
		if(a>=b && a>=c) {
			max=a;
			min1=b;
			min2=c;
		}
		else if(b>=a && b>=c) {
			max=b;
			min1=a;
			min2=c;
		}
		if(almostEquals(min1*min1+min2*min2,max*max))
			return "right";
		if(min1*min1+min2*min2<max*max)
			return "obtuse";
		return "actute";
	}

	protected String getTriangleSideType() {
		double a = Figure.getLength(points[0],points[1]);
		double b = Figure.getLength(points[1],points[2]);
		double c = Figure.getLength(points[2],points[0]);
		if(almostEquals(a, b) && almostEquals(c, b))
			return "equilateral";
		if(almostEquals(a, b) || almostEquals(c, b) || almostEquals(a, c))
			return "isosceles";
		return "scalene";
	}

	private boolean almostEquals(double a, double b) {
		double precision = Math.pow(10, -10);
		if(a==b)
			return true;
		if(Math.abs(a-b)<precision)
			return true;
		return false;
	}

	@Override
	public double getArea() {
		double a = Figure.getLength(points[0],points[1]);
		double b = Figure.getLength(points[1],points[2]);
		double c = Figure.getLength(points[2],points[0]);
		double p =(a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	@Override
	public String getType() {
		return "Triangle";
	}

}
