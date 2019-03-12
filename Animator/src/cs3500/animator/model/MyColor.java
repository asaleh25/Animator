package cs3500.animator.model;

import java.awt.Color;

/**
 * Represents a color.
 */
public class MyColor {

  private double r;
  private double g;
  private double b;

  /**
   * Creates a color.
   * @param r red portion of the color
   * @param g green portion of the color
   * @param b blue portion of the color
   */
  public MyColor(double r, double g, double b) {

    if (r < 0 || g < 0 || b < 0) {

      throw new IllegalArgumentException("No negative colors");

    }

    this.r = r;
    this.g = g;
    this.b = b;


  }

  /**
   * Copy constructor
   * @param c the color to be copied
   */
  public MyColor(MyColor c) {
    this.r = c.r;
    this.g = c.g;
    this.b = c.b;
  }

  @Override
  public boolean equals(Object o) {

    if (o instanceof MyColor) {
      MyColor temp = (MyColor)o;
      return this.r == temp.r && this.g == temp.g && this.b == temp.b;

    } else {

      return false;

    }

  }

  @Override
  public int hashCode() {


    return (int)(r * 31 + 31 * 31 * g + 31 * 31 * 31 * b);

  }

  /**
   * Turns myColor into a Color.
   * @return a Color
   */
  public Color getColor() {

    return new Color((int)this.r, (int)this.g, (int)this.b);

  }

  @Override
  public String toString() {

    return "(" + this.r + "," + this.g + "," + this.b + ")";

  }

}
