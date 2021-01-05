import java.awt.Color;

/**
 * [Trapezoid.java]
 * A quadrilateral with only one pair of parallel sides
 * extends Quadrilateral
 * @author Ethan Zhang
 * 2020/11/10
 */
class Trapezoid extends Quadrilateral {
  private int angleA, angleB;
  /**
   * Trapezoid constructor
   * @param xPos, the x coordinate of the trapezoid
   * @param yPos, the y coordinate of the trapezoid
   * @param colour, the colour of the trapezoid
   * @param width, the width, or height, of the trapezoid
   * @param length, the length of the bottom side of the trapezoid
   * @param angleA, the angle between the bottom side and the left side of the trapezoid in degrees
   * @param angleB, the angle between the bottom side and the right side of the trapezoid in degrees
   */
  Trapezoid(int xPos, int yPos, Color colour, int width, int length, int angleA, int angleB) {
    super(xPos, yPos, colour, width, length);
    this.angleA = angleA;
    this.angleB = angleB;
  }
  
  /**
   * getAngleA
   * Returns the angle between the bottom side and the left side of the trapezoid in degrees
   * @return int, the angle between the bottom side and the left side of the trapezoid in degrees
   */
  public int getAngleA() {
    return angleA;
  }
  
  /**
   * getAngleB
   * Returns the angle between the bottom side and the right side of the trapezoid in degrees
   * @return int, the angle between the bottom side and the right side of the trapezoid in degrees
   */
  public int getAngleB() {
    return angleB;
  }
  
  /**
   * getLeftRun
   * Returns the run between the leftmost vertex and the second vertex from the left
   * @return double, the run between the leftmost vertex and the second vertex from the left
   */
  private double getLeftRun() {
    if (angleA <= 90) {
      return getWidth() / Math.tan(Math.toRadians(angleA));
    } else {
      return getWidth() / Math.tan(Math.toRadians(180 - angleA));
    }
  }
  
  /**
   * getRightRun
   * Returns the run between the rightmost vertex and the second vertex from the right
   * @return double, the run between the rightmost vertex and the second vertex from the right
   */
  private double getRightRun() {
    if (angleB <= 90) {
      return getWidth() / Math.tan(Math.toRadians(angleB));
    } else {
      return getWidth() / Math.tan(Math.toRadians(180 - angleB));
    }
  }
  
  /**
   * getVertexXPos
   * Returns the x coordinates of the vertices of the trapezoid
   * @return int[], the x coordinates of the vertices of the trapezoid
   */
  public int[] getVertexXPos() {
    if (angleA <= 90) {
      return new int[] {getXPos() + 250, getXPos() + getLength() + 250, 
        getXPos() + getLength() - (int)Math.round(getRightRun()) + 250, 
        getXPos() + (int)Math.round(getLeftRun()) + 250};
    } else {
      return new int[] {getXPos() + (int)Math.round(getLeftRun()) + 250, 
        getXPos() + (int)Math.round(getLeftRun()) + getLength() + 250, 
        getXPos() + (int)Math.round(getLeftRun()) + getLength() + (int)Math.round(getRightRun()) + 250, 
        getXPos() + 250};
    }
  }
  
  /**
   * getVertexYPos
   * Returns the y coordinates of the vertices of the trapezoid
   * @return int[], the y coordinates of the vertices of the trapezoid
   */
  public int[] getVertexYPos() {
    return new int[] {getYPos() + getWidth() + 250, getYPos() + getWidth() + 250, getYPos(), getYPos() + 250};
  }
  
  /**
   * getTopLength
   * Returns the length of the top length of the trapezoid
   * @return double, the length of the top base of the trapezoid
   */
  public double getTopLength() {
    int[] xVertices = getVertexXPos();
    int[] yVertices = getVertexYPos();
    return Math.sqrt(Math.pow(xVertices[3] - xVertices[2], 2) + Math.pow(yVertices[3] - yVertices[2], 2));
  }
  
  /** 
   * getLeftSide
   * Returns the length of the left side of the trapezoid
   * @return double, the length of the left side of the trapezoid
   */
  public double getLeftSide() {
    int[] xVertices = getVertexXPos();
    int[] yVertices = getVertexYPos();
    return Math.sqrt(Math.pow(xVertices[3] - xVertices[0], 2) + Math.pow(yVertices[3] - yVertices[0], 2));
  }
  
  /** 
   * getRightSide
   * Returns the length of the right side of the trapezoid
   * @return double, the length of the right side of the trapezoid
   */
  public double getRightSide() {
    int[] xVertices = getVertexXPos();
    int[] yVertices = getVertexYPos();
    return Math.sqrt(Math.pow(xVertices[2] - xVertices[1], 2) + Math.pow(yVertices[2] - yVertices[1], 2));
  }
  
  /**
   * checkValidity
   * Checks if the provided dimensions are able to form a trapezoid or not
   * @throws InvalidTrapezoidException, when the given dimensions cannot form a trapezoid
   */
  public void checkValidity() throws InvalidTrapezoidException {
    int[] xVertices = getVertexXPos();
    if (angleA <= 90) {
      if (angleB >= 90) {
        throw new InvalidTrapezoidException();
      } else if (xVertices[3] <= xVertices[2]) {
        throw new InvalidTrapezoidException();
      }
    } else {
      if (angleB < 90) {
        throw new InvalidTrapezoidException();
      }
    }
  }
  
  /**
   * getPerimeter
   * Returns the perimeter by adding all side lengths together
   * @return double, the perimeter of the trapezoid
   */
  @Override
  public double getPerimeter() {
    return (getWidth() / Math.sin(Math.toRadians(angleA))) + (getWidth() / Math.sin(Math.toRadians(angleB))) +
      getLength() + getTopLength();
  }
  
  /**
   * getArea
   * Returns the area of the trapezoid by using its standard equation
   * @return double, the area of the trapezoid
   */
  @Override
  public double getArea() {
    return ((getTopLength() + getLength()) / 2) * getWidth(); //here
  }
  
  /**
   * checkDimensions
   * Checks if the given dimensions are zero or negative and if given angles are out of range
   * @throws InvalidDimensionException, when dimensions are zero or negative or angles are out of range
   */
  @Override
  public void checkDimensions() throws InvalidDimensionException {
    if (getWidth() <= 0 || getLength() <= 0 || angleA >= 180 || angleA <= 0 || angleB >= 180 || angleB <= 0) {
      throw new InvalidDimensionException();
    }
  }
}