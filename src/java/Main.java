import java.util.Scanner;
class Main {
	public static boolean inputCheck(String input, String key){
		if (input.trim().toLowerCase().equals(key))
			return true;
		return false;
	}
  public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String eq = "";
		while(!inputCheck(eq, "d")){
			System.out.println("What type of equation([l]inear, [q]uadratic, [c]ubic [d]one):");
			eq = scan.nextLine();
			if (inputCheck(eq, "l")){
				System.out.println("----------------------------------\nLinear Equation Calculator\nFor the equation y = Mx + B, please enter(if not availible, enter blank):");
				boolean isSlope = false; boolean isYint = false; boolean isP1 = false; boolean isP2 = false; double slope = 0.0; double yInt = 0.0; Point p1 = new Point(); Point p2 = new Point(); Line l = new Line(); boolean run = false;
				System.out.print("\n	M = ");
				String slopeIn = scan.nextLine();
				if (!slopeIn.trim().isBlank()){
					isSlope = true;
				}
				if (isSlope){
					try{
						slope = Double.parseDouble(slopeIn);
					}
					catch(IllegalArgumentException e){
						System.out.println("Invalid Slope.");
						isSlope = false;
					}
				}
				System.out.print("\n	B = ");
				String yIntIn = scan.nextLine();
				if (!yIntIn.trim().isBlank()){
					isYint = true;
				}
				if (isYint){
					try{
						yInt = Double.parseDouble(yIntIn);
					}
					catch(IllegalArgumentException e){
						System.out.println("Invalid Y-intercept.");
						isYint = false;
					}
				}
				if (isSlope && isYint){
					l = new Line(slope, yInt);
					run = true;
				}
				if (!run){
					System.out.println("\nDo you have a point on the line to enter?(y/n)");
					String input = scan.nextLine();
					if (inputCheck(input, "y")){
						System.out.println("\nFor coordinate ( x , y ), please enter:");
						System.out.print("\n	x = ");
						String xIn = scan.nextLine();
						System.out.print("\n	y = ");
						String yIn = scan.nextLine();
						try{
							double d = Double.parseDouble(xIn);
							double d2 = Double.parseDouble(yIn);
							p1 = new Point(d, d2);
							isP1 = true;
						}
						catch(IllegalArgumentException e){
							System.out.println("Invalid Input.");
						}
						if (isSlope&& isP1){
							l = new Line(slope, p1);
							run = true;
						}
						else if (isP1 && isYint){
							l = new Line(p1, yInt);
							run = true;
						}
						if (!run){
							System.out.println("\nDo you have another point on the line to enter?(y/n)");
							input = scan.nextLine();
							if (inputCheck(input, "y")){
								System.out.println("\nFor coordinate ( x , y ), please enter:");
								System.out.print("\n	x = ");
								xIn = scan.nextLine();
								System.out.print("\n	y = ");
								yIn = scan.nextLine();
								try{
									double d = Double.parseDouble(xIn);
									double d2 = Double.parseDouble(yIn);
									p2 = new Point(d, d2);
									isP2 = true;
								}
								catch(IllegalArgumentException e){
									System.out.println("Invalid Input.");
								}
							}
						}
					}
				}
				if (isP1 && isP2){
					l = new Line(p1, p2);
					run = true;
				}
				else if (!run){System.out.println("Insufficient data.");}
				if (run){
					l.printInfo();
				}
			}
			else if (eq.trim().toLowerCase().equals("q")){
			System.out.println("----------------------------------\nQuadratic Equation Calculator\nFor the equation Ax^2 + Bx + C = 0, please enter:");
			System.out.print("\n	A = ");
			String aIn = scan.nextLine();
			System.out.print("\n	B = ");
			String bIn = scan.nextLine();
			System.out.print("\n	C = ");
			String cIn = scan.nextLine();
			double a = 0.0; double b = 0.0; double c = 0.0; boolean run = false; Quadratic q = new Quadratic();
			try{
				a = Double.parseDouble(aIn);
				b = Double.parseDouble(bIn);
				c = Double.parseDouble(cIn);
				run = true;
			}catch(IllegalArgumentException e){
				System.out.println("Invalid input.");
			}
			if (run){
				q = new Quadratic(a,b,c);
				q.printInfo();
			}
		}
		else if (inputCheck(eq, "c")){
			System.out.println("----------------------------------\nCubic Equation Calculator\nFor the equation Ax^3 + Bx^2 + Cx + D = 0, please enter:");
			System.out.print("\n	A = ");
			String aIn = scan.nextLine();
			System.out.print("\n	B = ");
			String bIn = scan.nextLine();
			System.out.print("\n	C = ");
			String cIn = scan.nextLine();
			System.out.print("\n	D = ");
			String dIn = scan.nextLine();
			double a = 0.0; double b = 0.0; double c = 0.0; double d = 0.0;boolean run = false; Cubic cub = new Cubic();
			try{
				a = Double.parseDouble(aIn);
				b = Double.parseDouble(bIn);
				c = Double.parseDouble(cIn);
				d = Double.parseDouble(dIn);
				run = true;
			}catch(IllegalArgumentException e){
				System.out.println("Invalid input.");
			}
			if (run){
				cub = new Cubic(a,b,c,d);
				cub.printInfo();
			}
		}
		}
	}
}
