public abstract class Figure {

	public void printInformation() {
		System.out.println("Type: "+getType());
		if(this instanceof Triangle)
			System.out.println("Type of triangle: "+((Triangle)this).getTriangleType());
		System.out.format("Circuit: %.2f\n",getCircuit());
		System.out.format("Area: %.2f\n",getArea());
	}

	public abstract double getArea();

	public abstract String getType();
	
	public abstract String printInfoLog();

	public static boolean checkIfLinear(Point[] points) {
		if (points.length == 3 || points[3]==null)
			return checkIfThreePointsAreLinear(points[0],points[1],points[2]);
		if (points.length == 4) {
			if (checkIfThreePointsAreLinear(points[0],points[1],points[2]))
				return true;
			if (checkIfThreePointsAreLinear(points[0],points[1],points[3]))
				return true;	
			if (checkIfThreePointsAreLinear(points[0],points[2],points[3]))
				return true;
			if (checkIfThreePointsAreLinear(points[1],points[2],points[3]))
				return true;
		}
		return false;	
	}

	private static boolean checkIfThreePointsAreLinear(Point point1, Point point2, Point point3) {
		return checkIfLineIsParralels(point1,point2,point1,point3);
	}

	public static boolean checkIfParallelogram(Point[] points) {
		if(!checkIfTrapeze(points))
			return false;		
		if(checkIfLineIsParralels(points[0],points[1],points[2],points[3]) ) {
			if(checkIfLineIsParralels(points[0],points[3],points[1],points[2]) )
				return true;
		}
		return false;
		
	}

	public static boolean checkIfLineIsParralels(Point point1, Point point2, Point point3, Point point4) {
		if((point2.getX()-point1.getX())*(point3.getY()-point4.getY())==
				(point2.getY()-point1.getY())*(point3.getX()-point4.getX()))
			return true;
		return false;
	}

	public static boolean checkIfRectangle(Point[] points) {
		if(!checkIfParallelogram(points))
			return false;
		if(checkIsRight(points[0],points[1],points[2]))
			if(checkIsRight(points[2],points[3],points[0]))		
				return true;
		return false;
	}

	public static boolean checkIsRight(Point point1, Point point2, Point point3) {
		if((point2.getX()-point1.getX())*(point2.getX()-point3.getX())==
				-(point2.getY()-point1.getY())*(point2.getY()-point3.getY()))
			return true;
		return false;
	}

	public static boolean checkIfSquare(Point[] points) {
		if(!checkIfRectangle(points))
			return false;
		if(getLength(points[0],points[1])==getLength(points[1],points[2]))
			return true;
		return false;
	}

	public static double getLength(Point point1, Point point2) {
		return Math.sqrt(Math.pow(point1.getX()-point2.getX(), 2)+Math.pow(point1.getY()-point2.getY(), 2));
	}

	public static boolean checkIfTrapeze(Point[] points) {
		if(checkIfLineIsParralels(points[0],points[1],points[2],points[3]) )
			return true;
		if(checkIfLineIsParralels(points[0],points[3],points[1],points[2]) )
			return true;
		return false;		
	}
	
	public abstract double getCircuit();
	
}
