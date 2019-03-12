package cs3500.animator.model;

/**
 * Represents a Rectangle, a more specific type of shape.
 */
public class Rectangle extends AShape {

  private double width;
  private double height;
  private Posn llc;

  /**
   * Creates a rectangle.
   * @param name Name of the rectangle
   * @param color Color of the rectangle
   * @param appears When the rectangle appears
   * @param disappears When the rectangle disappears
   * @param width Width of the rectangle
   * @param height Height of the rectangle
   * @param llc position of the lower left corner of the rectangle
   */
  public Rectangle(String name, MyColor color, int appears,
                   int disappears, double width, double height, Posn llc) {

    super(name, color, appears, disappears);
    if (width < 0 || height < 0) {

      throw new IllegalArgumentException("Rectangle Values can't be negative.");

    }
    this.width = width;
    this.height = height;
    this.llc = llc;

  }

  /**
   * Determines if o is equal to this.
   * @param o object to be compared
   * @return whether or not o is equal to this.
   */
  public boolean sameShape(Object o) {

    if (o instanceof Rectangle) {

      Rectangle temp = (Rectangle)o;
      return this.name.equals(temp.name) && this.color.equals(temp.color) &&
              this.appears == temp.appears && this.disappears == temp.disappears &&
              this.width == temp.width && this.height == temp.height &&
              this.llc.equals(temp.llc);

    } else {

      return false;

    }

  }

  /**
   * Getter for width.
   * @return this.width
   */
  public double getWidth() {

    return this.width;

  }

  /**
   * Getter for height.
   * @return this.height
   */
  public double getHeight() {

    return this.height;

  }

  /**
   * Getter for LLC.
   * @return this.LLC
   */
  public Posn getLLC() {

    return this.llc;

  }

  @Override
  public String toString() {

    return "Name: " + this.name + "\nType: rectangle \nLower-left corner: " +
            this.llc.toString() + ", Width: " +
            this.width + ", Height: " + this.height + ", Color: " + this.color.toString() +
            "\nAppears at t=" + this.appears + "\nDisappears at t=" + this.disappears;

  }

}
