package cs3500.animator.model;

/**
 * To Represent a type of shape.
 */
public abstract class AShape {

  protected String name;
  protected MyColor color;
  protected int appears;
  protected int disappears;

  /**
   * Creates an AShape.
   * @param name name of the shape
   * @param color color of the shape
   * @param appears when the shape appears
   * @param disappears when the shape disappears
   */
  public AShape(String name, MyColor color, int appears, int disappears) {

    if (appears < 0 || disappears < 0) {

      throw new IllegalArgumentException("Time can't be negative");

    }
    this.name = name;
    this.color = color;
    this.appears = appears;
    this.disappears = disappears;

  }

  /**
   * Getter for appears.
   * @return appears
   */
  public int starts() {

    return this.appears;

  }

  /**
   * Getter for disappears.
   * @return disappears
   */
  public int ends() {

    return this.disappears;

  }

  /**
   * Getter for name.
   * @return name
   */
  public String getName() {

    return this.name;

  }

  /**
   * Getter for color.
   * @return color
   */
  public MyColor getColor() {

    return this.color;

  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof AShape)) {
      return false;
    }

    AShape that = (AShape)other;
    if (this instanceof Rectangle) {

      return ((Rectangle)this).sameShape(that);

    } else if (this instanceof Oval) {

      return ((Oval)this).sameShape(that);

    } else {

      throw new IllegalArgumentException("Shape does not exist");

    }
  }

  @Override
  public int hashCode() {

    return this.appears + this.disappears + this.color.hashCode() + this.name.hashCode();

  }

}
