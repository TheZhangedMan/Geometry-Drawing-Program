import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * [GeometryDrawingProgram.java]
 * A program that allows the user to draw two dimensional shapes on a JFrame
 * @authors Ethan Zhang, Mr. Mangat
 * 2020/10/11
 */

class GeometryDrawingProgram {
  static JFrame frame;
  private static ArrayList<Shape> shapes = new ArrayList<Shape>();
  
  /**
   * main
   * The main method that runs the program
   * @param args, a String array of arguments
   */
  public static void main(String[] args) {  
    GeometryScreen gs = new GeometryScreen();
    Scanner input = new Scanner(System.in);
    int option;
    int x, y;
    int valueA = 0, valueB = 0, valueC = 0, valueD = 0;
    int red = 0, green = 0, blue = 0;
    boolean added;
    boolean running = true;
    Shape temp = new Square(0, 0, new Color(0, 0, 0), 1, 1); //Initialized as a throwaway Square
    String type;
    int lastIndex = 0;
    
    System.out.println("Welcome to the Geometry Drawing Program! Enter the respective number to perform an action.");
    do {
      System.out.println("1. List Shape Data\n2. Add Shape\n3. Remove Shape\n4. Translate Shape" +
                         "\n5. Translate Drawing\n6. Modify Shape\n7. Save Drawing\n8. Load Drawing" +
                         "\n9. Quit Program");
      option = input.nextInt();
      
      if (option == 1) {
        listShapes();
      } else if (option == 2) {
        added = false;
        System.out.println("1. Square\n2. Rectangle\n3. Triangle\n4. Circle\n5. Ellipse\n6. Rhombus" +
                           "\n7. Parallelogram\n8. Trapezoid\nWhat shape would you like to add?:");
        option = input.nextInt();
        System.out.println("Enter the x coordinate of the shape:");
        x = input.nextInt();
        System.out.println("Enter the y coordinate of the shape:");
        y = input.nextInt();
        System.out.println("Enter the red, green, and blue values respectively:");
        
        try {
          red = input.nextInt();
          green = input.nextInt();
          blue = input.nextInt();
          if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
            throw new InvalidColourException();
          }
          
          if (option == 1) {
            System.out.println("Enter the side length:");
            valueA = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Square(x, y, new Color(red, green, blue), valueA, valueA));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Square(x, y, new Color(red, green, blue), valueA, valueA));
              lastIndex = shapes.size() - 1;
            }
          } else if (option == 2) {
            System.out.println("Enter the length:");
            valueA = input.nextInt();
            System.out.println("Enter the width:");
            valueB = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Rectangle(x, y, new Color(red, green, blue), valueA, valueB));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Rectangle(x, y, new Color(red, green, blue), valueA, valueB));
              lastIndex = shapes.size() - 1;
            }
          } else if (option == 3) {
            System.out.println("Enter the length of the base:");
            valueA = input.nextInt();
            System.out.println("Enter the length of the side left to the base:");
            valueB = input.nextInt();
            System.out.println("Enter the value of the angle between the base and the left side in degrees:");
            valueC = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Triangle(x, y, new Color(red, green, blue), valueA, valueB, valueC));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Triangle(x, y, new Color(red, green, blue), valueA, valueB, valueC));
              lastIndex = shapes.size() - 1;
            }
          } else if (option == 4) {
            System.out.println("Enter the length of the radius:");
            valueA = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Circle(x, y, new Color(red, green, blue), valueA, valueA));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Circle(x, y, new Color(red, green, blue), valueA, valueA));
              lastIndex = shapes.size() - 1;
            }
          } else if (option == 5) {
            System.out.println("Enter the length of the horizontal semi-axis:");
            valueA = input.nextInt();
            System.out.println("Enter the length of the vertical semi-axis:");
            valueB = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Ellipse(x, y, new Color(red, green, blue), valueA, valueB));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Ellipse(x, y, new Color(red, green, blue), valueA, valueB));
              lastIndex = shapes.size() - 1;
            }
          } else if (option == 6) {
            System.out.println("Enter the side length:");
            valueA = input.nextInt();
            System.out.println("Enter the value of the angle between the bottom side and the left side in degrees:");
            valueB = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Rhombus(x, y, new Color(red, green, blue), valueA, valueA, valueB));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Rhombus(x, y, new Color(red, green, blue), valueA, valueA, valueB));
              lastIndex = shapes.size() - 1;
            }
          } else if (option == 7) {
            System.out.println("Enter the diagonal side length:");
            valueA = input.nextInt();
            System.out.println("Enter the horizontal side length:");
            valueB = input.nextInt();
            System.out.println("Enter the value of the angle between the bottom side and the left side in degrees:");
            valueC = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Parallelogram(x, y, new Color(red, green, blue), valueA, valueB, valueC));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Parallelogram(x, y, new Color(red, green, blue), valueA, valueB, valueC));
              lastIndex = shapes.size() - 1;
            }
          } else if (option == 8) {
            System.out.println("Enter the length of the bottom base:");
            valueA = input.nextInt();
            System.out.println("Enter the height:");
            valueB = input.nextInt();
            System.out.println("Enter the angle between the bottom base and the left side in degrees:");
            valueC = input.nextInt();
            System.out.println("Enter the angle between the bottom base and the right side in degrees:");
            valueD = input.nextInt();
            for (int i = 0; i < shapes.size(); i++) {
              if (shapes.get(i) == null && !added) {
                shapes.add(i, new Trapezoid(x, y, new Color(red, green, blue), valueB, valueA, valueC, valueD));
                lastIndex = i;
                added = true;
              }
            }
            
            if (!added) {
              shapes.add(new Trapezoid(x, y, new Color(red, green, blue), valueB, valueA, valueC, valueD));
              lastIndex = shapes.size() - 1;
            }
          } else {
            System.out.println("Invalid input.");
          }
          
          if (shapes.size() != 0 && shapes.get(lastIndex) instanceof Trapezoid) {
            ((Trapezoid)shapes.get(lastIndex)).checkValidity();
          }
          if (shapes.size() != 0) {
            shapes.get(lastIndex).checkDimensions();
          }
        } catch (InvalidColourException e) {
          System.out.println(e.getMessage());
        } catch (InvalidTrapezoidException e) {
          shapes.remove(lastIndex);
          System.out.println(e.getMessage());
        } catch (InvalidDimensionException e) {
          shapes.remove(lastIndex);
          System.out.println(e.getMessage());
        }
      } else if (option == 3) {
        listShapes();
        if (shapes.size() != 0) {
          System.out.println("Enter a number to remove the respective shape.");
          option = input.nextInt();
          if (shapes.get(option - 1) != null) {
            shapes.remove(option - 1);
          } else {
            System.out.println("There is no shape at the inputted index.");
          }
        }
      } else if (option == 4) {
        listShapes();
        if (shapes.size() != 0) {
          System.out.println("Enter a number to move the respective shape.");
          option = input.nextInt();
          if (shapes.get(option - 1) != null) {
            System.out.println("Enter the displacement of the x coordinate:");
            shapes.get(option - 1).setXPos(shapes.get(option - 1).getXPos() + input.nextInt());
            System.out.println("Enter the displacement of the y coordinate:");
            shapes.get(option - 1).setYPos(shapes.get(option - 1).getYPos() + input.nextInt());
          } else {
            System.out.println("There is no shape at the inputted index.");
          }
        }
      } else if (option == 5) {
        if (shapes.size() != 0) {
          System.out.println("Enter the displacement of the x coordinate:");
          valueA = input.nextInt();
          System.out.println("Enter the displacement of the y coordinate:");
          valueB = input.nextInt();
          for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != null) {
              shapes.get(i).setXPos(shapes.get(i).getXPos() + valueA);
              shapes.get(i).setYPos(shapes.get(i).getYPos() + valueB);
            }
          }
        }
      } else if (option == 6) {
        listShapes();
        if (shapes.size() != 0) {
          try {
            System.out.println("Enter a number to modify the respective shape.");
            option = input.nextInt();
            
            if (shapes.get(option - 1) != null) {
              System.out.println("Enter the red, green, and blue values respectively:");
              red = input.nextInt();
              green = input.nextInt();
              blue = input.nextInt();
              if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
                throw new InvalidColourException();
              }
            }
            
            if (shapes.get(option - 1) instanceof Square) {
              System.out.println("Enter the side length:");
              valueA = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Square(shapes.get(option - 1).getXPos(), shapes.get(option - 1).getYPos(), 
                                                new Color(red, green, blue), valueA, valueA));
            } else if (shapes.get(option - 1) instanceof Rectangle) {
              System.out.println("Enter the length:");
              valueA = input.nextInt();
              System.out.println("Enter the width:");
              valueB = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Rectangle(shapes.get(option - 1).getXPos(), shapes.get(option - 1).getYPos(), 
                                                   new Color(red, green, blue), valueA, valueB));
            } else if (shapes.get(option - 1) instanceof Triangle) {
              System.out.println("Enter the length of the base:");
              valueA = input.nextInt();
              System.out.println("Enter the length of the side left to the base:");
              valueB = input.nextInt();
              System.out.println("Enter the value of the angle between the base and the left side in degrees:");
              valueC = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Triangle(shapes.get(option - 1).getXPos(), shapes.get(option - 1).getYPos(), 
                                                  new Color(red, green, blue), valueA, valueB, valueC));
            } else if (shapes.get(option - 1) instanceof Circle) {
              System.out.println("Enter the length of the radius:");
              valueA = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Circle(shapes.get(option - 1).getXPos(), shapes.get(option - 1).getYPos(), 
                                                new Color(red, green, blue), valueA, valueA));
            } else if (shapes.get(option - 1) instanceof Ellipse) {
              System.out.println("Enter the length of the horizontal semi-axis:");
              valueA = input.nextInt();
              System.out.println("Enter the length of the vertical semi-axis:");
              valueB = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Ellipse(shapes.get(option - 1).getXPos(), shapes.get(option - 1).getYPos(), 
                                                 new Color(red, green, blue), valueA, valueB));
            } else if (shapes.get(option - 1) instanceof Rhombus) {
              System.out.println("Enter the side length:");
              valueA = input.nextInt();
              System.out.println("Enter the value of the angle between the bottom side and the left side:");
              valueB = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Rhombus(shapes.get(option - 1).getXPos(), shapes.get(option - 1).getYPos(), 
                                                 new Color(red, green, blue), valueA, valueA, valueB));
            } else if (shapes.get(option - 1) instanceof Parallelogram) {
              valueA = input.nextInt();
              System.out.println("Enter the horizontal side length:");
              valueB = input.nextInt();
              System.out.println("Enter the value of the angle between the bottom side and the left side in degrees:");
              valueC = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Parallelogram(shapes.get(option - 1).getXPos(), 
                                                       shapes.get(option - 1).getYPos(), new Color(red, green, blue), 
                                                       valueA, valueB, valueC));
            } else if (shapes.get(option - 1) instanceof Trapezoid) {
              System.out.println("Enter the length of the bottom base:");
              valueA = input.nextInt();
              System.out.println("Enter the height:");
              valueB = input.nextInt();
              System.out.println("Enter the angle between the bottom base and the left side in degrees:");
              valueC = input.nextInt();
              System.out.println("Enter the angle between the bottom base and the right side in degrees:");
              valueD = input.nextInt();
              temp = shapes.get(option - 1);
              shapes.set(option - 1, new Trapezoid(shapes.get(option - 1).getXPos(), shapes.get(option - 1).getYPos(), 
                                                   new Color(red, green, blue), valueB, valueA, valueC, valueD));
            } else {
              System.out.println("There is no shape at the inputted index.");
            }
            
            if (shapes.get(option - 1) instanceof Trapezoid) {
              ((Trapezoid)shapes.get(option - 1)).checkValidity();
            }
            if (shapes.get(option - 1) != null) {
              shapes.get(option - 1).checkDimensions();
            }
          } catch (InvalidColourException e) {
            System.out.println(e.getMessage());
          } catch (InvalidTrapezoidException e) {
            shapes.set(option - 1, temp);
            System.out.println(e.getMessage());
          } catch (InvalidDimensionException e) {
            shapes.set(option - 1, temp);
            System.out.println(e.getMessage());
          }
        } 
      } else if (option == 7) {
        System.out.println("Enter the name of the save file:");
        input.nextLine();
        File file = new File(input.nextLine() + ".txt");
        try {
          PrintWriter output = new PrintWriter(file);
          for (int i = 0; i < shapes.size(); i++) {
            temp = shapes.get(i);
            if (temp instanceof Square) {
              output.println("Square " + temp.getXPos() + " " + temp.getYPos() + " " + temp.getColour().getRed() + 
                             " " + temp.getColour().getGreen() + " " + temp.getColour().getBlue() + " " + 
                             ((Square)temp).getLength());
            } else if (temp instanceof Rectangle) {
              output.println("Rectangle " + temp.getXPos() + " " + temp.getYPos() + " " + temp.getColour().getRed() + 
                             " " + temp.getColour().getGreen() + " " + temp.getColour().getBlue() + " " +
                             ((Rectangle)temp).getWidth() + " " + ((Rectangle)temp).getLength());
            } else if (temp instanceof Triangle) {
              output.println("Triangle " + temp.getXPos() + " " + temp.getYPos() + " " + temp.getColour().getRed() + 
                             " " + temp.getColour().getGreen() + " " + temp.getColour().getBlue() + " " +
                             ((Triangle)temp).getBase() + " " + ((Triangle)temp).getLeftSide() + " " +
                             ((Triangle)temp).getAngle());
            } else if (temp instanceof Circle) {
              output.println("Circle " + temp.getXPos() + " " + temp.getYPos() + " " + temp.getColour().getRed() + 
                             " " + temp.getColour().getGreen() + " " + temp.getColour().getBlue() + " " +
                             ((Circle)temp).getSemiAxisA());
            } else if (temp instanceof Ellipse) {
              output.println("Ellipse " + temp.getXPos() + " " + temp.getYPos() + " " + temp.getColour().getRed() + 
                             " " + temp.getColour().getGreen() + " " + temp.getColour().getBlue() + " " +
                             ((Ellipse)temp).getSemiAxisA() + " " + ((Ellipse)temp).getSemiAxisB());
            } else if (temp instanceof Rhombus) {
              output.println("Rhombus " + temp.getXPos() + " " + temp.getYPos() + " " + temp.getColour().getRed() + 
                             " " + temp.getColour().getGreen() + " " + temp.getColour().getBlue() + " " +
                             ((Rhombus)temp).getLength() + " " + ((Rhombus)temp).getAngle());
            } else if (temp instanceof Parallelogram) {
              output.println("Parallelogram " + temp.getXPos() + " " + temp.getYPos() + " " + 
                             temp.getColour().getRed() + " " + temp.getColour().getGreen() + " " + 
                             temp.getColour().getBlue() + " " + ((Parallelogram)temp).getWidth() + " " + 
                             ((Parallelogram)temp).getLength() + " " + ((Parallelogram)temp).getAngle());
            } else if (temp instanceof Trapezoid) {
              output.println("Trapezoid " + temp.getXPos() + " " + temp.getYPos() + " " + temp.getColour().getRed() + 
                             " " + temp.getColour().getGreen() + " " + temp.getColour().getBlue() + " " +
                             ((Trapezoid)temp).getWidth() + " " + ((Trapezoid)temp).getLength() + " " +
                             ((Trapezoid)temp).getAngleA() + " " + ((Trapezoid)temp).getAngleB());
            }
          }
          output.close();
        } catch (FileNotFoundException e) {
          System.out.println("Failed to save file...");
        }
      } else if (option == 8) {
        System.out.println("Enter the name of the file to load from:");
        input.nextLine();
        File file = new File(input.nextLine() + ".txt");
        try {
          Scanner read = new Scanner(file);
          shapes.clear();
          while (read.hasNext()) {
            type = read.next();
            if (type.equals("Square")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              shapes.add(new Square(x, y, new Color(red, green, blue), valueA, valueA));
            } else if (type.equals("Rectangle")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              valueB = read.nextInt();
              shapes.add(new Rectangle(x, y, new Color(red, green, blue), valueA, valueB));
            } else if (type.equals("Triangle")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              valueB = read.nextInt();
              valueC = read.nextInt();
              shapes.add(new Triangle(x, y, new Color(red, green, blue), valueA, valueB, valueC));
            } else if (type.equals("Circle")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              shapes.add(new Circle(x, y, new Color(red, green, blue), valueA, valueA));
            } else if (type.equals("Ellipse")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              valueB = read.nextInt();
              shapes.add(new Ellipse(x, y, new Color(red, green, blue), valueA, valueB));
            } else if (type.equals("Rhombus")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              valueB = read.nextInt();
              shapes.add(new Rhombus(x, y, new Color(red, green, blue), valueA, valueA, valueB));
            } else if (type.equals("Parallelogram")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              valueB = read.nextInt();
              valueC = read.nextInt();
              shapes.add(new Parallelogram(x, y, new Color(red, green, blue), valueA, valueB, valueC));
            } else if (type.equals("Trapezoid")) {
              x = read.nextInt();
              y = read.nextInt();
              red = read.nextInt();
              green = read.nextInt();
              blue = read.nextInt();
              valueA = read.nextInt();
              valueB = read.nextInt();
              valueC = read.nextInt();
              valueD = read.nextInt();
              shapes.add(new Trapezoid(x, y, new Color(red, green, blue), valueA, valueB, valueC, valueD));
            }
          }
        } catch (FileNotFoundException e) {
          System.out.println("Save file not found...");
        }
      } else if (option == 9) {
        running = false;
      } else {
        System.out.println("Invalid input.");
      }
      
      frame.repaint(); //Update the screen
    } while (running);
  }
  
  /**
   * listShapes
   * Lists all existing shapes and corresponding data in the console
   */
  private static void listShapes() {
    Shape temp;
    
    if (shapes.size() == 0) {
      System.out.println("There are no shapes in the drawing.");
    }
    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i) != null) {
        temp = shapes.get(i);
        
        if (temp instanceof Square) {
          System.out.println((i + 1) + ". Square, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Side Length: " + ((Square)temp).getLength() + ", Perimeter: " + 
                             temp.getPerimeter() + ", Area: " + temp.getArea());
        } else if (temp instanceof Rectangle) {
          System.out.println((i + 1) + ". Rectangle, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Width: " + ((Rectangle)temp).getWidth() + ", Length: " + 
                             ((Rectangle)temp).getLength() + ", Perimeter: " + temp.getPerimeter() + ", Area: " + 
                             temp.getArea());
        } else if (temp instanceof Triangle) {
          System.out.println((i + 1) + ". Triangle, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Side Lengths: " + ((Triangle)temp).getBase() + ", " + 
                             ((Triangle)temp).getLeftSide() + ", " + ((Triangle)temp).getRightSide() +
                             ", Height: " + ((Triangle)temp).getHeight() + ", Perimeter: " + temp.getPerimeter() +
                             ", Area: " + temp.getArea());
        } else if (temp instanceof Circle) {
          System.out.println((i + 1) + ". Circle, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Radius: " + ((Circle)temp).getSemiAxisA() + ", Circumference: " +
                             temp.getPerimeter() + ", Area: " + temp.getArea());
        } else if (temp instanceof Ellipse) {
          System.out.println((i + 1) + ". Ellipse, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Horizontal Semi Axis: " + ((Ellipse)temp).getSemiAxisA() + 
                             ", Vertical Semi Axis: " + ((Ellipse)temp).getSemiAxisB() + 
                             ", Approximate Perimeter: " + temp.getPerimeter() + ", Area: " + temp.getArea());
        } else if (temp instanceof Rhombus) {
          System.out.println((i + 1) + ". Rhombus, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Side Length: " + ((Rhombus)temp).getLength() + ", Left Angle: " +
                             ((Rhombus)temp).getAngle() + ", Perimeter: " + temp.getPerimeter() + ", Area: " +
                             temp.getArea());
        } else if (temp instanceof Parallelogram) {
          System.out.println((i + 1) + ". Parallelogram, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Width: " + ((Parallelogram)temp).getWidth() + ", Length: " +
                             ((Parallelogram)temp).getLength() + ", Left Angle: " + 
                             ((Parallelogram)temp).getAngle() + ", Perimeter: " + temp.getPerimeter() + 
                             ", Area: " + temp.getArea());
        } else if (temp instanceof Trapezoid) {
          System.out.println((i + 1) + ". Trapezoid, Coordinates: (" + temp.getXPos() + ", " + temp.getYPos() + 
                             "), Side Lengths: " + ((Trapezoid)temp).getLength() + ", " + 
                             ((Trapezoid)temp).getTopLength() + ", " + ((Trapezoid)temp).getLeftSide() + ", " + 
                             ((Trapezoid)temp).getRightSide() + ", Height: " + ((Trapezoid)temp).getWidth() + 
                             ", Perimeter: " + temp.getPerimeter() + ", Area: " + temp.getArea());
        }
      }
    }
  }
  
  //This is an inner class - it has access to the static variables defined above
  /**
   * [GeometryScreen.java]
   * Creates the JFrame for drawing
   * @author Mr. Mangat
   * 2020/10/11
   */
  public static class GeometryScreen {
    /**
     * GeometryScreen constructor
     * Creates the JFrame
     */
    GeometryScreen() {
      frame = new JFrame("Geometry Drawing Program 1.0");
      
      //Create a new "custom" panel for graphics based on the inner class below
      JPanel graphicsPanel = new GraphicsPanel();
      
      //Add the panel and the frame to the window
      frame.getContentPane().add(graphicsPanel);
      
      // Set the frame to full screen 
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(520,540);
      frame.setUndecorated(false);  //Set to true to remove title bar
      frame.setVisible(true);
      
    } 
    
//This is an inner class which contains all the details about drawing to screen
    /**
     * [GraphicsPanel.java]
     * Visually displays all drawn aspects on a JPanel
     * @authors Ethan Zhang, Mr. Mangat
     * 2020/10/11
     */
    public static class GraphicsPanel extends JPanel {
      Shape temp;
      
      /**
       * paintComponent
       * Places all drawn aspects onto the JPanel
       * @param g, Graphics for drawing
       */
      public void paintComponent(Graphics g) {          
        setDoubleBuffered(true);   
        g.setColor(Color.BLACK);
        //Draw the x and y axes
        g.drawLine(250, 0, 250, 500);
        g.drawLine(0, 250, 500, 250);
        
        //Coordinates are relative to the axes
        //All shapes are drawn inside a rectangle with its top left vertex being at the specified coordinates
        for (int i = 0; i < shapes.size(); i++) {
          if (shapes.get(i) != null) {
            g.setColor(shapes.get(i).getColour());
            temp = shapes.get(i);
          }
          
          if (temp instanceof Rectangle) {
            g.drawRect(temp.getXPos() + 250, temp.getYPos() + 250, ((Rectangle)temp).getWidth(), 
                       ((Rectangle)temp).getLength());
          } else if (temp instanceof Triangle) {
            g.drawPolygon(((Triangle)temp).getVertexXPos(), ((Triangle)temp).getVertexYPos(), 3);
          } else if (temp instanceof Ellipse) {
            g.drawOval(temp.getXPos() + 250, temp.getYPos() + 250, ((Ellipse)temp).getSemiAxisA(), 
                       ((Ellipse)temp).getSemiAxisB());
          } else if (temp instanceof Parallelogram) {
            g.drawPolygon(((Parallelogram)temp).getVertexXPos(), ((Parallelogram)temp).getVertexYPos(), 4);
          } else if (temp instanceof Trapezoid) {
            g.drawPolygon(((Trapezoid)temp).getVertexXPos(), ((Trapezoid)temp).getVertexYPos(), 4);
          }
        }
      }
    }
  }
}