import java.awt.Color;

/**
 * [Triangle.java]
 * A shape with three sides
 * extends Shape
 * @author Ethan Zhang
 * 2020/11/10
 */
class Triangle extends Shape {
  private int base;
  private int leftSide;
  private int angle;
  /**
   * Triangle constructor
   * @param xPos, the x coordinate of the triangle
   * @param yPos, the y coordinate of the triangle
   * @param colour, the colour of the triangle
   * @param base, the length of the base of the triangle
   * @param leftSide, the length of the side left to the base
   * @param angle, the angle between the base and the side left of it in degrees
   */
  Triangle(int xPos, int yPos, Color colour, int base, int leftSide, int angle) {
    super(xPos, yPos, colour);
    this.base = base;
    this.leftSide = leftSide;
    this.angle = angle;
  }
  
  /**
   * getBase
   * Returns the length of the base of the triangle
   * @return int, the base of the triangle
   */
  public int getBase() {
    return base;
  }
  
  /**
   * getAngle
   * Returns the angle between the base and the side left of it in degrees
   * @return int, the angle between the base and the side left of it in degrees
   */
  public int getAngle() {
    return angle;
  }
  
  /**
   * getHeight
   * Returns the height of the triangle with the use of its standard area equation
   * @return double, the height of the triangle
   */
  public double getHeight() {
    return (2 * getArea()) / base;
  }
  
  /**
   * getLeftSide
   * Returns the length of the side left of the base
   * @return int, the length of the side left of the base
   */
  public int getLeftSide() {
    return leftSide;
  }
  
  /**
   * getRightSide
   * Returns the length of the side right of the base
   * @return double, the length of the side right of the base
   */
  public double getRightSide() {
    return Math.sqrt((base * base) + (leftSide * leftSide) - ((2 * base * leftSide) * Math.cos(angle)));
  }
  
  /**
   * getRun
   * Returns the run between the leftmost vertex and the second vertex from the left
   * @return double, the run between the leftmost vertex and the second vertex from the left
   */
  private double getRun() {
    if (angle < 90) {
      return leftSide * Math.cos(Math.toRadians(angle));
    } else {
      return leftSide * Math.cos(Math.toRadians(180 - angle));
    }
  }
  
  /**
   * getVertexXPos
   * Returns the x positions of all the vertices of the triangle
   * @return int[], the x positions of the vertices of the triangle
   */
  public int[] getVertexXPos() {
    if (angle <= 90) {
      return new int[] {getXPos() + 250, getXPos() + base + 250, getXPos() + (int)Math.round(getRun()) + 250};
    } else {
      return new int[] {getXPos() + (int)Math.round(getRun()) + 250, 
        getXPos() + base + (int)Math.round(getRun()) + 250, getXPos() + 250};
    }
  }
  
  /**
   * getVertexYPos
   * Returns the y positions of all the vertices of the triangle
   * @return int[], the y positions of the vertices of the triangle
   */
  public int[] getVertexYPos() {
    return new int[] {getYPos() + (int)Math.round(getHeight()) + 250, 
      getYPos() + (int)Math.round(getHeight()) + 250, getYPos() + 250};
  }
  
  /**
   * getPerimeter
   * Returns the perimeter by adding all side lengths of the triangle together
   * @return double, the perimeter of the triangle
   */
  @Override
  public double getPerimeter() {
    return base + getLeftSide() + getRightSide();
  }
  
  /**
   * getArea
   * Returns the area of the triangle by using cosine law
   * @return double, the area of the triangle
   */
  @Override
  public double getArea() {
    double semiPerimeter = getPerimeter() / 2;
    return Math.sqrt(semiPerimeter * (semiPerimeter - getLeftSide()) * (semiPerimeter - getRightSide()) *
    (semiPerimeter - base));
  }
  
  /**
   * checkDimensions
   * Checks if the given side lengths are zero or negative and if angles are out of range
   * @throws InvalidDimensionException, when the given side lengths are zero or negative or angles are out of range
   */
  @Override
  public void checkDimensions() throws InvalidDimensionException {
    if (base <= 0 || leftSide <= 0 || angle >= 180 || angle <= 0) {
      throw new InvalidDimensionException();
    }
  }
}