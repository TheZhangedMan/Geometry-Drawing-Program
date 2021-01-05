import java.awt.Color;

/**
 * [Rhombus.java]
 * A quadrilateral with equal sides and two pairs of equal angles
 * extends Parallelogram
 * @author Ethan Zhang
 * 2020/11/10
 */
class Rhombus extends Parallelogram {
  /**
   * Rhombus constructor
   * @param xPos, the x coordinate of the rhombus
   * @param yPos, the y coordinate of the rhombus
   * @param colour, the colour of the rhombus
   * @param width, the width of the diagonal side
   * @param length, the length of the horizontal side
   * @param angle, the angle between the bottom horizontal side and the left diagonal side in degrees
   */
  Rhombus(int xPos, int yPos, Color colour, int width, int length, int angle) {
    super(xPos, yPos, colour, width, length, angle);
  }
}