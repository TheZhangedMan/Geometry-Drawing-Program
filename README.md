# Geometry Drawing Program
A drawing program that can draw a variety of shapes and display the attributes of drawn shapes.
* This is the summative for the first unit of ICS4UE, reviewing basic principles of object-oriented programming and exception handling
* The following shapes can be drawn: circles, ellipses, parallelograms, rectangles, rhombuses, squares, trapezoids, and triangles
* Commands, such as drawing shapes and viewing details, are done via the console
    * Shapes are drawn on a JFrame
* The specified coordinates for all shapes correspond to the upper left corner of the shape and NOT the centre of the shape
    * This is based on the way Java draws shapes on a JFrame
* If invalid dimensions are provided for the drawing of a shape, the user is notified and the shape is not drawn
* Provided coordinates are drawn relative to the x-axis and y-axis that are visually present on the JFrame
    * For instance, a shape specified to be drawn at (0, 0) will be drawn at the centre of the JFrame and not the upper left corner of the JFrame
* Drawings can be saved in the form of a text file and can later on be loaded