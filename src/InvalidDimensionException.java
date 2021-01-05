/**
 * [InvalidDimensionException.java]
 * A custom exception that arises when an invalid side length or angle is entered
 * extends Exception
 * @author Ethan Zhang
 * 2020/11/10
 */
class InvalidDimensionException extends Exception {
  /**
   * InvalidDimensionException constructor
   * Creates an exception with a custom message
   */
  InvalidDimensionException() {
    super("Invalid dimension(s) entered.");
  }
}