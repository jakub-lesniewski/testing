public abstract class Polygon extends Figure{
	protected Point[] points;

	@Override
	public String printInfoLog() {
		StringBuilder sb = new StringBuilder(getType()+" vertices: ");
		for(Point p:points)
			sb.append("("+p.getX()+","+p.getY()+") ");
		return sb.toString();
	}

	@Override
	public double getCircuit() {
		double circuit = 0;
		for(int i=0;i<points.length;i++)
			circuit += Figure.getLength(points[i], points[(i+1)%points.length]);
		return circuit;
	}
}
