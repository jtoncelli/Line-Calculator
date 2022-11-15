class Point{
	private double x; 
	private double y;
	public Point(){
		x = 0; 
		y = 0;
	}
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	public Point(Point p){
		this.x = p.getX();
		this.y = p.getY();
	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y;
	}
	public double getSlope(Point p){
		if (x - p.getX() == 0)
			return Double.NaN;
		return ((y - p.getY())/(x - p.getX()));		
	}
	public boolean equals(Point p){
		if (this.x == p.getX() && this.y == p.getY())
			return true;
		return false;
	}
	public void printPoint(){
		System.out.println("(" + x + "," + y + ")");
	}
	public String getPoint(){
		return("(" + x + "," + y + ")");
	}
}
