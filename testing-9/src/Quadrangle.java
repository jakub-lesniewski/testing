public class Quadrangle extends Polygon {

	public Quadrangle(Point[] points) {
		this.points = new Point[4];
		for(int i=0;i<4;i++)
			this.points[i]=points[i];
	}

	@Override
	public double getArea() {
		Triangle triangle1 = new Triangle(new Point[]{points[0],points[1],points[2]});
		Triangle triangle2 = new Triangle(new Point[]{points[0],points[2],points[3]});
		return triangle1.getArea()+triangle2.getArea();
	}

	@Override
	public String getType() {
		return "Quadrangle";
	}
}
