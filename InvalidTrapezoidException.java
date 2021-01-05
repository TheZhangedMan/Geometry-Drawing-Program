/**
 * [InvalidTrapezoidException.java]
 * A custom exception that arises when the inputted values for a trapezoid cannot form a trapezoid
 * extends Exception
 * @author Ethan Zhang
 * 2020/11/10
 */
class InvalidTrapezoidException extends Exception {
  /**
   * InvalidDimensionException constructor
   * Creates an exception with a custom message
   */
  InvalidTrapezoidException() {
    super("A trapezoid cannot be formed with the given values.");
  }
}