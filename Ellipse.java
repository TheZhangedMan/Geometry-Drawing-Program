import java.awt.Color;

/**
 * [Ellipse.java]
 * A rounded two-dimensional shape with semi-axes of different length
 * extends Shape
 * @author Ethan Zhang
 * 2020/11/10
 */
class Ellipse extends Shape {
  private int semiAxisA, semiAxisB;
  /**
   * Ellipse constructor
   * @param xPos, the x coordinate of the ellipse
   * @param yPos, the y coordinate of the ellipse
   * @param colour, the colour of the ellipse
   * @param semiAxisA, the length of the horizontal semi-axis
   * @param semiAxisB, the length of the vertical semi-axis
   */
  Ellipse(int xPos, int yPos, Color colour, int semiAxisA, int semiAxisB) {
    super(xPos, yPos, colour);
    this.semiAxisA = semiAxisA;
    this.semiAxisB = semiAxisB;
  }
  
  /**
   * getSemiAxisA
   * Returns the horizontal semi-axis
   * @return int, the length of the horizontal semi-axis
   */
  public int getSemiAxisA() {
    return semiAxisA;
  }
  
  /**
   * getSemiAxisB
   * Returns the horizontal semi-axis
   * @return int, the length of the vertical semi-axis
   */
  public int getSemiAxisB() {
    return semiAxisB;
  }

  /**
   * getPerimeter
   * Returns the perimeter of the ellipse using the most basic approximate equation for an ellipse
   * @return double, the perimeter of the ellipse
   */
  @Override
  public double getPerimeter() {
    return 2 * Math.PI * Math.sqrt(((semiAxisA * semiAxisA) + (semiAxisB * semiAxisB)) / 2);
  }
  
  /**
   * getPerimeter
   * Returns the area of the ellipse using its standard equation
   * @return double, the area of the ellipse
   */
  @Override
  public double getArea() {
    return Math.PI * semiAxisA * semiAxisB;
  }
  
  /**
   * checkDimensions
   * Checks if given dimensions are zero or negative
   * @throws InvalidDimensionException, when the given dimensions are zero or negative
   */
  @Override
  public void checkDimensions() throws InvalidDimensionException {
    if (semiAxisA <= 0 || semiAxisB <= 0) {
      throw new InvalidDimensionException();
    }
  }
}