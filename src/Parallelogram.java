import java.awt.Color;

/**
 * [Parallelogram.java]
 * A quadrilateral with two pairs of equal sides and two pairs of equal angles
 * extends Quadrilateral
 * @author Ethan Zhang
 * 2020/11/10
 */
class Parallelogram extends Quadrilateral {
  private int angle;
  /**
   * Parallelogram constructor
   * @param xPos, the x coordinate of the parallelogram
   * @param yPos, the y coordinate of the parallelogram
   * @param colour, the colour of the parallelogram
   * @param width, the width of the diagonal side
   * @param length, the length of the horizontal side
   * @param angle, the angle between the bottom horizontal side and the left diagonal side in degrees
   */
  Parallelogram(int xPos, int yPos, Color colour, int width, int length, int angle) {
    super(xPos, yPos, colour, width, length);
    this.angle = angle;
  }
  
  /**
   * getAngle
   * Returns the angle between the bottom horizontal side and the left diagonal side in degrees
   * @return int, the angle between the bottom horizontal side and the left diagonal side in degrees
   */
  public int getAngle() {
    return angle;
  }
  
  /**
   * getHeight
   * Returns the height of the parallelogram by using trigonometric functions
   * @return double, the height of the parallelogram
   */
  public double getHeight() {
    if (angle < 90) {
      return getWidth() * Math.sin(Math.toRadians(angle));
    } else {
      return getWidth() * Math.sin(Math.toRadians(180 - angle));
    }
  }
  
  /**
   * getRun
   * Returns the run between the leftmost vertex and the second vertex from the left by using trigonometry
   * @return double, the run between the leftmost vertex and the second vertex from the left
   */
  private double getRun() {
    if (angle < 90) {
      return getWidth() * Math.cos(Math.toRadians(angle));
    } else {
      return getWidth() * Math.cos(Math.toRadians(180 - angle));
    }
  }
  
  /**
   * getVertexXPos
   * Returns the x positions of all the vertices of the parallelogram
   * @return int[], the x positions of the vertices of the parallelogram
   */
  public int[] getVertexXPos() {
    return new int[] {getXPos() + 250, getXPos() + getLength() + 250, 
      getXPos() + (int)Math.round(getRun()) + getLength() + 250, getXPos() + (int)Math.round(getRun()) + 250};
  }
  
  /**
   * getVertexYPos
   * Returns the y positions of all the vertices of the parallelogram
   * @return int[], the y positions of the vertices of the parallelogram
   */
  public int[] getVertexYPos() {
    if (angle < 90) {
      return new int[] {getYPos() + (int)Math.round(getHeight()) + 250, getYPos() + (int)Math.round(getHeight()) + 250, 
        getYPos() + 250, getYPos() + 250};
    } else {
      return new int[] {getYPos() + 250, getYPos() + 250, getYPos() + (int)Math.round(getHeight()) + 250,
        getYPos() + (int)Math.round(getHeight()) + 250};
    }
  }
  
  /**
   * getPerimeter
   * Returns the perimeter of the parallelogram by adding two of its widths with to of its lengths
   * @return double, the perimeter of the parallelogram
   */
  @Override
  public double getPerimeter() {
    return (2 * getLength()) + (2 * getWidth());
  }
  
  /**
   * getArea
   * Returns the area of the paralellogram by multiplying its width by its height
   * @return double, the area of the paralellogram
   */
  @Override
  public double getArea() {
    return getLength() * getHeight();
  }
  
  /**
   * checkDimensions()
   * Checks if the given side lengths are zero or negative and if the given angle is not in range
   * @throws InvalidDimensionException, when the given side lengths are zero or negative or if the angle is not in range
   */
  @Override
  public void checkDimensions() throws InvalidDimensionException {
    if (getWidth() <= 0 || getLength() <= 0 || angle >= 180 || angle <= 0) {
      throw new InvalidDimensionException();
    }
  }
}