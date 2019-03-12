package cs3500.animator.model;

/**
 * Represents a Posn, which is an ordered pair (x, y).
 */
public class Posn {

  private double x;
  private double y;

  /**
   * Creates a posn.
   * @param x x-value
   * @param y y-value
   */
  public Posn(double x, double y) {

    if (this.x < 0 || this.y < 0) {

      throw new IllegalArgumentException("Posn cannot be negative");

    }
    this.x = x;
    this.y = y;

  }

  /**
   * Copy constructor
   * @param p the posn to be copied
   */
  public Posn(Posn p) {
    this.x = p.x;
    this.y = p.y;
  }

  @Override
  public boolean equals(Object o) {

    if (o instanceof Posn) {

      Posn temp = (Posn)o;
      return this.x == temp.x && this.y == temp.y;

    } else {

      return false;

    }

  }

  @Override
  public int hashCode() {

    return (int)(this.x < this.y ? this.y * this.y + this.x : this.x * this.x + this.x + this.y);

  }

  /**
   * Getter method for the x value.
   */
  public double getX() {

    return this.x;

  }

  /**
   * Getter method for the y value.
   * @return the y value
   */
  public double getY() {

    return this.y;

  }

  @Override
  public String toString() {

    return "(" + this.x + "," + this.y + ")";

  }
}
