# Line-Calculator
A calculator that can analyze linear, quadratic, and cubic equations. 

## Creating Points

I first made a **Point** class, which has the attributes x and y. I also added a few methods to make future calculations easier shown below:

```java
  public double getSlope(Point p){ //returns the slope between this point object and another }
  public boolean equals(Point p){ //returns true or false based on the coordinates }
  public void printPoint(){ //prints a representation of the point in the format, (x, y) }
  public String getPoint(){ //returns a representation of the point in the format, (x, y) }

```

In all the different classes of equations, I used the Point class in some way, but mostly in the Line class. 

## Linear Equations

The **Line** class is a template for linear equations.

It has four class attributes:
- double slope
- Point p1
- Point p2
- double yInt. 

It has 6 constructors with different parameters, listed below:

```java
  public Line(){
    //with no parameters it defaults to a y = x line
    //finds the slope and yInt, and sets p1 and p2 to (0, 0) and (1, 1)
  }
  public Line(Point p1, Point p2){ //finds the slope and y-intercept }
  public Line(Point p, double yInt){ //finds the slope and another point on the line }
  public Line(double slope, double yInt){ //finds two points on the line }
  public Line(double slope, Point p){ //finds the y-intercept and another point }
  public Line(double x1, double y1, double x2, double y2 ){ //sets the two points given and finds a slope and y-intercept }

```

I made the multiple constructors so that the user could input whatever information they have, and the program would find the rest. The user must provide two of the four attributes to meet the qualifications of a linear equation. The driving code in Main calls the correct constructor once enough information has been inputted. 

Below is a summary of the functions of all of the Line class methods, except getters and setters:

```java
  public String getEquation(){ //returns a string representation of the equation in y = mx + b format }
  public double findY(double x){ //returns the associated Y value with the provided X value }
  public double findX(double y){ //returns the associated Y value with the provided X value }
  public double findIntegral(double x){ //returns the area between the line and the graph from 0 to the specified x value }
  public void printInfo(){ //prints all of the line's information in a nice format }
```

## Quadratic Equations

The **Quadratic** class provides a template for second degree equations. 

It has 6 class attributes:
- double a;
-	double b;
-	double c;
-	double [] zeros = new double[2];
-	double AOS;
-	Point vertex;

The a, b, and c values correspond with the ax<sup>2</sup> + bx + c = 0 format of a quadratic equation. The zeros array can be filled with the up to 2 possible solutions of the equations. The isReal boolean is ONLY set to false if there are no solutions. The AOS double corresponds with the x-value over which the parabola has symmetry, or axis of symmetry. Finally, the vertex is a Point object where the vertex is found.

I only made 2 constructors for this class, one that defulats to y = x<sup>2</sup>, and another that accepts a, b, and c and finds the rest of the points. 

Below are descriptions of all of the class methods, except getters and setters:

```java
  public boolean isQuadratic(){ //returns true unless a = 0; i.e; unless it is not a quadratic }
  public double [] findZeros(double cIn){ //finds the solutions, if any, for the quadratic equation at a given y value }
  public double findAOS(){ //finds the axis of symmetry using -b/2a }
  public double [] findX(double y){ //finds the up to 2 solutions at a y-value using findZeros() }
  public double findY(double x){ //finds the y-value associated with an x-value }
  public String getEquation(){ //returns a string representation of the equation in the ax^2 + bx + c = 0 format }
  public void printInfo(){ //displays all of the information associated with the equation in a nice format }
```

## Cubic Equations

Finally, the **Cubic** class represents a third degree equation. 

It has 5 attributes: a, b, c, d, and an array for the zeros. The first 4 align with the ax<sup>3</sup> + bx<sup>2</sup> + cx + d = 0. 

This class also only has two constructors, just like the Quadratic class. It either defaults to y = x<sup>3</sup> or accepts a, b, c, and d as inputs. 
