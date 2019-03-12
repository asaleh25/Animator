package cs3500.hw05.oldModel;

/**
 * Provides a definition and common methods for any geometric object that the animator must know
 * about.
 */
public abstract class GeometryObject {
  protected Position2D posn;
  protected MyColor color;
  protected String name;

  GeometryObject(String name, Position2D posn, MyColor color) {
    this.name = name;
    this.posn = posn;
    this.color = color;
  }

  /**
   * Updates the location of the shape on a cartesian plane.
   * @param xVel the amount that the x coordinate is to change by.
   * @param yVel the amount that the y coordinate is to change by.
   */
  public void updateLocation(double xVel, double yVel) {
    this.posn = new Position2D(this.posn.getX() + xVel, this.posn.getY() + yVel);
  }

  /**
   * Updates the color of the shape. Allows for gradual changes in color.
   * @param rVel the amount the red value to change by.
   * @param gVel the amount the green value to change by.
   * @param bVel the amount the blue value to change by.
   */
  public void updateColor(double rVel, double gVel, double bVel) {
    this.color = new MyColor(this.color.Red() + rVel, this.color.Green() + gVel, this.color
            .Blue() + bVel);
  }

  /**
   * Changes the size of the shape. Abstract and must be implemented by every new shape dependent
   * on how the size of the shape is defined.
   * @param t a timespan by which the shape is to change.
   * @param x the final sizing along the x parameter.
   * @param y the final sizing along the y parameter.
   */
  public abstract void resize(int t, double x, double y);

  /**
   * Returns the location of the object
   * @return the location of the object
   */
  public Position2D getLocation() {
    return this.posn;
  }

  public MyColor getColor() {
    return this.color;
  }
}
