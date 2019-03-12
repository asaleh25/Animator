package cs3500.hw05.oldModel;

import java.util.Objects;

/**
 * Defines a representation for colors using values between 0.0 and 1.0 to define the ratio of
 * red, green, and blue.
 */
public class MyColor {
  private double r;
  private double g;
  private double b;

  public MyColor(double r, double g, double b) {
    if (r < 0.0 || r > 1.0 || g < 0.0 || g > 1.0 || b < 0.0 || b > 1.0) {
      throw new IllegalArgumentException("RGB values must be between 0.0 and 1.0");
    }

    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Returns the red value of the color.
   * @return double representing the percent of the color that is red.
   */
  public double Red() {
    return r;
  }

  /**
   * Returns the green value of the color.
   * @return double representing the percent of the color that is green.
   */
  public double Green() {
    return g;
  }

  /**
   * Returns the blue value of the color.
   * @return double representing the percent of the color that is blue.
   */
  public double Blue() {
    return b;
  }

  @Override
  public String toString() {
    return String.format("(%.2f, %.2f, %.2f)", this.r, this.g, this.b);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof MyColor)) {
      return false;
    }

    MyColor c = (MyColor) obj;
    return Math.abs(this.g - c.g) < 0.01 && Math.abs(this.r - c.r) < 0.01 && Math.abs(this.b - c
            .b) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.r, this.g, this.b);
  }
}
