import java.awt.Color;

/**
 * [Rectangle.java]
 * A quadrilateral with four equal angles
 * extends Quadrilateral
 * @author Ethan Zhang
 * 2020/11/10
 */
class Rectangle extends Quadrilateral {
  /**
   * Rectangle constructor
   * @param xPos, the x coordinate of the rectangle
   * @param yPos, the y coordinate of the rectangle
   * @param colour, the colour of the rectangle
   * @param width, the width of the vertical side
   * @param length, the length of the horizontal side
   */
  Rectangle(int xPos, int yPos, Color colour, int width, int length) {
    super(xPos, yPos, colour, width, length);
  }
  
  /**
   * getPerimeter
   * Returns the perimeter of the rectangle by adding two of its widths with two of its lengths
   * @return double, the perimeter of the rectangle
   */
  @Override
  public double getPerimeter() {
    return (2 * getLength()) + (2 * getWidth());
  }
  
  /**
   * getArea
   * Returns the area of the rectangle by multiplying its length by its width
   * @return double, the area of the rectangle
   */
  @Override
  public double getArea() {
    return getLength() * getWidth();
  }
  
  /**
   * checkDimensions
   * Checks if the side lengths of the rectangle are zero or negative
   * @throws InvalidDimensionException, when the given side lengths are zero or negative
   */
  @Override
  public void checkDimensions() throws InvalidDimensionException {
    if (getWidth() <= 0 || getLength() <= 0) {
      throw new InvalidDimensionException();
    }
  }
}