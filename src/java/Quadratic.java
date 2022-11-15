import java.util.Scanner;
class Quadratic{
	private double a;
	private double b;
	private double c;
	private double [] zeros = new double[2];
	private boolean isReal = true;
	private double AOS;
	private Point vertex;
	public Quadratic(){
		a = 1;
		b  = 0; 
		c = 0;
		zeros = findZeros(c);
		AOS = findAOS();
		vertex = new Point(AOS, findY(AOS));
	}
	public Quadratic(double a, double b, double c){
		this.a = a;
		this.b = b; 
		this.c = c;
		if (isQuadratic()){
			zeros = findZeros(c);
		}
		AOS = findAOS();
		vertex = new Point(AOS, findY(AOS));
	}
	public Point getVertex(){
		return vertex;
	}
	public boolean isQuadratic(){
		if (a!= 0.0)
			return true;
		return false;
	}
	public double [] findZeros(double cIn){
		double d =(b * b) - (4 * a * cIn);
		double [] points = new double[2];
		if (d >= 0) {
			points[0] = (-b + Math.sqrt(d)) / (2 * a);
      points[1] = (-b - Math.sqrt(d)) / (2 * a);
		}
		else if (d < 0){
			points[0] = Double.NaN;
			points[1] = Double.NaN;
			isReal = false;
		}
		return points;
	}
	public double findAOS(){
		return(-b/(2*a));
	}
	public double [] findX(double y){
		return findZeros(c - y);
	}
	public double findY(double x){
		return((a*x*x) + (b*x) + c);
	}
	public String getEquation(){
		return("y = " + a + "x^2" + (b == 0 ? "":" + " + b + "x" ) + (c == 0 ? "":" + " + c ));
	}
	public void printInfo(){
		Scanner scan = new Scanner(System.in);
		System.out.println("\n----------------------------------");
		System.out.println("Equation of the line: " + getEquation());
		System.out.println("Axis of Symmetry: " + AOS);
		System.out.println("Vertex: " );
		vertex.printPoint();
		System.out.println("Enter X: ");
		String input = scan.nextLine();
		try{
			double d = Double.parseDouble(input);
			System.out.println("(" + d + "," + findY(d) + ")");
		}catch(IllegalArgumentException e){
			System.out.println("Invalid input.");
		}
		System.out.println("Enter Y: ");
		input = scan.nextLine();
		try{
			double d = Double.parseDouble(input);
			double [] ans = findX(d);
			System.out.println("(" + ans[0] + "," + d + ") & (" + ans[1] + "," + d + ")");
		}catch(IllegalArgumentException e){
			System.out.println("Invalid input.");
		}
		System.out.println("----------------------------------\n");
	}
	
}
