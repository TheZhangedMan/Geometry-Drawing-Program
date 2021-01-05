import java.awt.Color;

/**
 * [Shape.java]
 * A two dimensional shape
 * @author Ethan Zhang
 * 2020/11/10
 */
abstract class Shape {
  private int xPos, yPos;
  private Color colour;
  /**
   * Shape constructor
   * @param xPos, the x coordinate of the shape
   * @param yPos, the y coordinate of the shape
   * @param colour, the colour of the shape
   */
  Shape(int xPos, int yPos, Color colour) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.colour = colour;
  }
  
  /**
   * getXPos
   * Returns the x coordinate of the shape
   * @return int, the x coordinate of the shape
   */
  public int getXPos() {
    return xPos;
  }
  
  /**
   * setXPos
   * Sets the x coordinate of the shape
   * @param xPos, the new x coordinate of the shape as an integer
   */
  public void setXPos(int xPos) {
    this.xPos = xPos;
  }
  
  /**
   * getYPos
   * Returns the y coordinate of the shape
   * @return int, the y coordinate of the shape
   */
  public int getYPos() {
    return yPos;
  }
  
  /**
   * setYPos
   * Sets the y coordinate of the shape
   * @param yPos, the new y coordinate of the shape as an integer
   */
  public void setYPos(int yPos) {
    this.yPos = yPos;
  }
  
  /**
   * getColour
   * Returns the colour of the shape
   * @return Color, the colour of the shape
   */
  public Color getColour() {
    return colour;
  }
  
  /**
   * getPerimeter
   * Returns the perimeter of the shape using its respective equation
   * @return double, the perimeter of the shape
   */
  public abstract double getPerimeter();
  
  /**
   * getArea
   * Returns the area of the shape using its respective equation
   * @return double, the area of the shape
   */
  public abstract double getArea();
  
  /**
   * checkDimensions
   * Checks if there are any invalid values in the shape
   * @throws InvalidDimensionException, when invalid values are detected
   */
  public abstract void checkDimensions() throws InvalidDimensionException;
}