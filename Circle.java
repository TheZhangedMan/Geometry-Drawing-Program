import java.awt.Color;

/**
 * [Circle.java]
 * An ellipse with semi-axes with equal length
 * extends Ellipse
 * @author Ethan Zhang
 * 2020/11/10
 */
class Circle extends Ellipse {
  /**
   * Circle constructor
   * @param xPos, the x coordinate of the circle
   * @param yPos, the y coordinate of the circle
   * @param colour, the colour of the circle
   * @param semiAxisA, the length of the horizontal semi-axis
   * @param semiAxisB, the length of the vertical semi-axis
   */
  Circle(int xPos, int yPos, Color colour, int semiAxisA, int semiAxisB) {
    super(xPos, yPos, colour, semiAxisA, semiAxisB);
  }
}