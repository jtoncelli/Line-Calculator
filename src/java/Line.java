import java.util.Scanner;
class Line{
	private double slope;
	private Point p1;
	private Point p2;
	private double yInt;

	public Line(){
		p1 = new Point(0,0);
		p2 = new Point(1,1);
		slope = p1.getSlope(p2);
		yInt = 0;
	}

	public Line(Point p10, Point p20){
		this.p1 = new Point(p10);
		this.p2 = new Point(p20);
		if(p1.equals(p2)){
			slope = 0;
			yInt = p1.getY();
		}
		else{
			slope = p1.getSlope(p2);
			if (Double.isNaN(slope)){
				yInt = Double.NaN;
			}
			else{
				yInt = findYint();
			}
		}
	}

	public Line(Point p, double yInt){
		this.yInt = yInt;
		p1 = new Point(p);
		p2 = new Point(0, yInt);
		if (p1.equals(p2)){
			slope = 0;
		}
		else{
			slope = this.p1.getSlope(this.p2);
		}
		
	}

	public Line(double slope, double yInt){
		this.slope = slope; 
		this.yInt = yInt;
		p1 = new Point(0, this.findY(0));
		p2 = new Point(findX(0), 0);
	}

	public Line(double slope, Point p){
		this.slope = slope; 
		this.p1 = new Point(p);
		if (Double.isNaN(slope)){
			yInt = p1.getY();
		}
		else{
			yInt = findYint();
		}
		p2 = new Point(findX(p1.getY() + 1.0), p1.getY() + 1.0);
	}

	public Line(double x1, double y1, double x2, double y2 ){
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
		if(p1.equals(p2)){
			slope = 0;
			yInt = p1.getY();
		}
		else{
			slope = p1.getSlope(p2);
			if (Double.isNaN(slope)){
				yInt = Double.NaN;
			}
			else{
				yInt = findYint();
			}
		}
	}
	
	public String getEquation(){
		if (Double.isNaN(slope)){
			return("x = " + p1.getX());
		}
		return ("y = " + slope + "x" + (yInt == 0 ? "" : " + " + yInt));
	}
	public double getSlope(){
		return slope;
	}
	public double getYint(){
		return yInt;
	}
	public String getPoints(){
		return (p1.getPoint() + " & " + p2.getPoint());
	}
	public double findYint(){
		return (p1.getY() - (p1.getX() * slope));
	}
	public double findY(double x){
		if (Double.isNaN(slope)){
			return Double.NaN;
		}
		return (slope*x) + yInt;
	}
	public double findX(double y){
		if (Double.isNaN(slope)){
			return p1.getX();
		}
		if (slope == 0){
			return Double.NaN;
		}
		return ((y - yInt) / slope);
	}
	public double findIntegral(double x){
		x = Math.abs(x);
		if (slope == 0){
			return (x*yInt);
		}
		else if (Double.isNaN(slope)){
			return Double.NaN;
		}
		else if(slope > 0){
			return (x * this.findY(x)) / 2;
		}
		return (x * yInt) / 2;
	}
	public void printInfo(){
		Scanner scan = new Scanner(System.in);
		System.out.println("\n----------------------------------");
		System.out.println("Equation of the line: " + getEquation());
		System.out.println("Slope: " + getSlope());
		System.out.println("Y-intercept: " + getYint());
		System.out.println("Points: " + getPoints());
		System.out.println("Enter X: ");
		String input = scan.nextLine();
		try{
			Double d = Double.parseDouble(input);
			System.out.println("(" + d + "," + findY(d) + ")");
			System.out.println("Area between x-axis and graph up to " + d +": " + findIntegral(d));
		}catch(IllegalArgumentException e){
			System.out.println("Invalid input.");
		}
		System.out.println("Enter Y: ");
		input = scan.nextLine();
		try{
			Double d = Double.parseDouble(input);
			System.out.println("(" + findX(d) + "," + d + ")");
		}catch(IllegalArgumentException e){
			System.out.println("Invalid input.");
		}
		System.out.println("----------------------------------\n");
	}
	

}
