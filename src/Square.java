import java.awt.Color;

/**
 * [Square.java]
 * A rectangle with four equal angles and four equal sides
 * extends Rectangle
 * @author Ethan Zhang
 * 2020/11/10
 */
class Square extends Rectangle {
  /**
   * Square constructor
   * @param xPos, the x coordinate of the square
   * @param yPos, the y coordinate of the square
   * @param colour, the colour of the square
   * @param width, the width of the vertical side
   * @param length, the length of the horizontal side
   */
  Square(int xPos, int yPos, Color colour, int width, int length) {
    super(xPos, yPos, colour, width, length);
  }
}