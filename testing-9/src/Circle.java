public class Circle extends Figure {
	
	private Point middle;
	private int radix;

	public Circle(Point[] points, int radix) {
		middle = points[0];
		this.radix = radix;
	}

	@Override
	public double getArea() {
		return Math.PI*radix*radix;
	}

	@Override
	public String getType() {
		return "Circle";
	}

	@Override
	public double getCircuit() {
		return 2*Math.PI*radix;
	}

	@Override
	public String printInfoLog() {
		return "Circle: middle ("+middle.getX()+","+middle.getY()+"), radix="+radix;
	}


}
