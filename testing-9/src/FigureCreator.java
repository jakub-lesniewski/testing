public class FigureCreator {

	public static Figure create(String line) {
		try {
			Point[] points = parseLine(line);
			if(points[3]!=null)
				return createqQuadrangle(points);
			if(points[2]!=null)
				if (!Figure.checkIfLinear(points))
					return new Triangle(points);
				else
					throw new Exception("Pasrising");					
			if(points[1]!=null)
				throw new Exception("Pasrising");
			line = line.substring(line.lastIndexOf(")")+2,line.length());
			int radix = Integer.valueOf(line);
			if(points[0]!=null && radix>0)
				return new Circle(points,radix);
		}
		catch(Exception ex) {
			System.err.println("Problem with parsing");
		}
		return null;
	}
	
	static protected Point[] parseLine(String line) throws Exception {
		Point[] points = new Point[4];
		int index = 0;
		while(line.contains("(")) {
			if(index == 4 || !line.contains(")") )
				throw new Exception("Parsing");
			String pointString = line.substring(line.indexOf("(")+1);
			pointString=pointString.substring(0,pointString.indexOf(")"));
			points[index] = new Point(Integer.valueOf(pointString.split(",")[0]),Integer.valueOf(pointString.split(",")[1]));
			line = line.substring(line.indexOf(")")+1);
			index++;
		}
		return points;
	}

	private static Figure createqQuadrangle(Point[] points) throws Exception {
		if (Figure.checkIfLinear(points))
			throw new Exception("Parsing");
		if (Figure.checkIfSquare(points))
			return new Square(points);
		if (Figure.checkIfRectangle(points))		
			return new Rectangle(points);
		if (Figure.checkIfParallelogram(points))
			return new Parallelogram(points);			
		if (Figure.checkIfTrapeze(points))
			return new Trapeze(points);			
		return new Quadrangle(points);
	}

}
