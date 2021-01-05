import java.awt.Color;

/**
 * [Quadrilateral.java]
 * A two dimensional shape with four sides
 * extends Shape
 * @author Ethan Zhang
 * 2020/11/10
 */
abstract class Quadrilateral extends Shape {
  private int width, length;
  /**
   * Quadrilateral constructor
   * @param xPos, the x coordinate of the quadrilateral
   * @param yPos, the y coordinate of the quadrilateral
   * @param colour, the colour of the quadrilateral
   * @param width, the width of the quadrilateral
   * @param length, the length of the quadrilateral
   */
  Quadrilateral(int xPos, int yPos, Color colour, int width, int length) {
    super(xPos, yPos, colour);
    this.width = width;
    this.length = length;
  }
  
  /**
   * getWidth
   * Returns the width of the quadrilateral
   * @returns int, the width of the quadrilateral
   */
  public int getWidth() {
    return width;
  }
  
  /**
   * getLength
   * Returns the length of the quadrilateral
   * @returns int, the length of the quadrilateral
   */
  public int getLength() {
    return length;
  }
}