/**
 * [InvalidColourException.java]
 * A custom exception that arises when an invalid RGB value is entered
 * extends Exception
 * @author Ethan Zhang
 * 2020/11/10
 */
class InvalidColourException extends Exception {
  /**
   * InvalidColourException constructor
   * Creates an exception with a custom message
   */
  InvalidColourException() {
    super("Invalid colour value(s) entered.");
  }
}