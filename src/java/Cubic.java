import java.util.Scanner;
class Cubic{
	private double a, b, c, d;
	private double[] zeros;
	public Cubic(){
		a = 1; 
		b = c = d = 0;
		zeros = solveCubic(a, b, c, d);
	}
	public Cubic(double a, double b, double c, double d){
		this.a = a; 
		this.b = b;
		this.c = c;
		this.d = d;
		zeros = solveCubic(a, b, c, d);
	}
	public String getEquation(){
		return("y = " + a + "x^3" + (b == 0 ? "":" + " + b + "x^2" ) + (c == 0 ? "":" + " + c + "x" ) + (d == 0 ? "" : " + " + d));
	}
	public double[] findX(double y){
		return solveCubic(a, b, c, d - y);
	}
	public double findY(double x){
		return (a*x*x*x + b*x*x + c*x + d);
	}
	public void printInfo(){
		Scanner scan = new Scanner(System.in);
		System.out.println("\n----------------------------------");
		System.out.println("Equation of the line: " + getEquation());
		System.out.println("Solution" + (zeros.length == 1 ? "" : "s") + ":");
			for (double z:zeros){
				System.out.print(" (" + z + ",0.0) ");
			}
		System.out.println("\nEnter X: ");
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
			System.out.println("Solution" + (ans.length == 1 ? " " : "s ") + "for Y = " + d + ":");
			for (double z:ans){
				System.out.print(" (" + z + "," + d + ") ");
			}
		}catch(IllegalArgumentException e){
			System.out.println("Invalid input.");
		}
		System.out.println("\n----------------------------------\n");
	}
	public double[] solveCubic(double a, double b, double c, double d){
		double[] result;
		if (a != 1) {
      b = b / a;
      c = c / a;
      d = d / a;
    }

    double p = (c / 3) - (b * b / 9);
    double q = ((b * b * b) / 27) - ((b * c) / 6) + (d / 2);
    double determinant = (p * p * p) +(q * q);
		determinant = (double)Math.round(determinant * 1000000000) / 1000000000;
    if (Double.compare(determinant, 0) >= 0) {
      if (Double.compare(determinant, 0) == 0) {
        double r = Math.cbrt(-q);
        result = new double[2];
        result[0] = 2 * r;
        result[1] = -r;
       } else {
          double r = Math.cbrt(-q + Math.sqrt(determinant));
          double s = Math.cbrt(-q - Math.sqrt(determinant));
          result = new double[1];
          result[0] = r + s;
       }
    } else {
      double ang = Math.acos(-q / Math.sqrt(-p * p * p));
      double r = 2 * Math.sqrt(-p);
      result = new double[3];
      for (int k = -1; k <= 1; k++) {
      	double theta = (ang - 2 * Math.PI * k) / 3;
        result[k + 1] = r * Math.cos(theta);
       }

    }
    for (int i = 0; i < result.length; i++) {
       result[i] = result[i] - b / 3;
			 result[i] = (double)Math.round(result[i] * 100000) / 100000;
    }

    return result;
	}
	
}
