package cs3500.animator.model;


/**
 * Represents an Oval, which is a more specific type of AShape.
 */
public class Oval extends AShape {

  private Posn center;
  private double xRadius;
  private double yRadius;

  /**
   * Creates an Oval.
   * @param name Name of the oval
   * @param color Color of the oval
   * @param appears When the oval appears
   * @param disappears When the oval disappears
   * @param center Center of the oval
   * @param xRadius X- Radius of the oval
   * @param yRadius Y- Radius of the oval
   */
  public Oval(String name, MyColor color, int appears, int disappears,
              Posn center, double xRadius, double yRadius) {

    super(name, color, appears, disappears);
    if (xRadius < 0 || yRadius < 0) {

      throw new IllegalArgumentException("Negative Oval Values Not Allowed");

    }
    this.center = center;
    this.xRadius = xRadius;
    this.yRadius = yRadius;

  }

  /**
   * Deternines is o is equal to this.
   * @param o object to be compared
   * @return whether or not o is equal to this
   */
  public boolean sameShape(Object o) {

    if (o instanceof Oval) {

      Oval temp = (Oval)o;
      return this.name.equals(temp.name) && this.color.equals(temp.color) &&
              this.appears == temp.appears && this.disappears == temp.disappears &&
              this.center.equals(temp.center) && this.xRadius == temp.xRadius &&
              this.yRadius == temp.yRadius;

    } else {

      return false;

    }

  }

  /**
   * Getter for xRadius.
   * @return this.xRadius
   */
  public double getxRadius() {

    return this.xRadius;

  }

  /**
   * Getter for yRadius.
   * @return yRadius
   */
  public double getyRadius() {


    return this.yRadius;

  }

  /**
   * Getter for center.
   * @return center
   */
  public Posn getCenter() {

    return this.center;

  }

  @Override
  public String toString() {

    return "Name: " + this.name + "\nType: oval\nCenter: " + this.center.toString() +
            ", X radius: " +
            this.xRadius + ", Y radius: " + this.yRadius + ", Color: " + this.color.toString() +
            "\nAppears at t=" + this.appears + "\nDisappears at t=" + this.disappears;

  }


}
