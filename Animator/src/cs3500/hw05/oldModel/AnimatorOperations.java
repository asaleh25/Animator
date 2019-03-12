package cs3500.hw05.oldModel;

/**
 * Defines common methods that any of the animator must implement
 */
public interface AnimatorOperations {
  /**
   * Calculates the current time frame.
   * @return an integer representation of the current time frame of the implementation of the
   * animation.
   */
  int currentTime();

  /**
   * Updates the current time to move to the next frame.
   */
  void updateTime();

  /**
   * Creates a new shape that appears and disappears at the given times, using the given
   * components for for the shapes sizes along the x and y axis. Note that squares and circles
   * are represented as rectangles and ellipses where both x and y components are the same size
   * and thus only the x component is used for those objects. See {@link GeometryObject} for more.
   * @param startTime the time at which the shape appears.
   * @param endTime the time at which the shape disappears.
   * @param name the name of the shape.
   * @param xComponent the size of the shape along the x-axis (x radius or width).
   * @param yComponent the size of the shape along the y-axis (y radius or height).
   * @param shape the type of the shape, used to determine whether both components are used or
   *              just the x component.
   * @param color the color of the shape.
   * @param loc the location of the shape on the plane.
   * @return A GeometryObject representing shape to be created.
   */
  GeometryObject createShape(int startTime, int endTime, String name, double xComponent, double
          yComponent, Position2D loc, MyColor color, ShapeType shape);

  /**
   * Updates the location of the given shape object, moving it towards the given location within
   * the time frame given.
   */
  void move(int startTime, int endTime, GeometryObject shape, Position2D endLocation);

  /**
   * Updates the color of the given shape in the time frame given.
   */
  void changeColor(int startTime, int endTime, GeometryObject shape, MyColor newColor);

  /**
   * Scales the dimensions of the given shape withing the given time frame. Note that if the
   * shape is a square or circle only the xSize will be used.
   * @param startTime the time at which the dimensions begin to scale.
   * @param endTime the time by which the dimension should have scaled.
   * @param newXSize the new size of the x component.
   * @param newYSize the new size of the y component.
   * @param shape the shape to be scaled.
   */
  void scale(int startTime, int endTime, GeometryObject shape, double newXSize, double newYSize);
}
