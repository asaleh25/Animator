// Credit to lecture notes

package cs3500.hw05.oldModel;

import java.util.Objects;

/**
 * This class represents a 2D position.
 */
public final class Position2D {
  private final double x;

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  private final double y;

  /**
   * Initialize this object to the specified position.
   */
  public Position2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Copy constructor.
   */
  public Position2D(Position2D v) {
    this(v.x, v.y);
  }

  @Override
  public String toString() {
    return String.format("(%.2f, %.2f)", this.x, this.y);
  }

  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Position2D)) {
      return false;
    }

    Position2D that = (Position2D) a;

    return ((Math.abs(this.x - that.x) < 0.01) && (Math.abs(this.y - that.y) < 0.01));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  /**
   * Calculates the distance between one position and another along the x-axis.
   */
  public double xDistance(Position2D that) {
    return that.x - this.x;
  }

  /**
   * Calculate the distance between one position and another along the y-axis.
   */
  public double yDistance(Position2D that) {
    return that.y - this.y;
  }

}
