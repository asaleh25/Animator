package cs3500.animator.model;

/**
 * Represents the animation scale.
 */
public class Scale extends AAnimation {

  private int variableOne;
  private int variableTwo;

  /**
   * Creates a scale animation.
   *
   * @param affected    affected shape
   * @param start       start time
   * @param end         end time
   * @param variableOne either new width or xRadius
   * @param variableTwo either new height or yRadius
   */
  public Scale(AShape affected, int start, int end, int variableOne, int variableTwo) {

    super(affected, start, end);
    if (variableOne < 0 || variableTwo < 0) {

      throw new IllegalArgumentException("New scaled values can't be negative");

    }

    this.variableOne = variableOne;
    this.variableTwo = variableTwo;

  }

  @Override
  public boolean equals(Object o) {

    if (o instanceof Scale) {

      Scale temp = (Scale) o;
      return this.affected.equals(temp.affected) && this.start == temp.start &&
              temp.end == this.end && this.variableTwo == temp.variableTwo &&
              this.variableOne == temp.variableOne;

    } else {

      return false;

    }

  }

  @Override
  public int hashCode() {

    return this.affected.hashCode() + this.start + this.end + this.variableOne + this.variableTwo;

  }

  @Override
  public String toString() {

    String start = "Shape " + this.affected.getName() + " scales from ";
    String end = " from t=" + this.start + " to t=" + this.end;
    String middle = "";

    if (this.affected instanceof Rectangle) {

      Rectangle temp = (Rectangle) this.affected;
      middle = "Width: " + temp.getWidth() + ", Height: " + temp.getHeight() +
              " to Width: " + this.variableOne + ", Height: " + this.variableTwo;

    }
    if (this.affected instanceof Oval) {

      Oval temp = (Oval) this.affected;
      middle = "X-Radius: " + temp.getxRadius() + ", Y-Radius: " + temp.getyRadius() +
              " to X-Radius: " + this.variableOne + ", Y-Radius: " + this.variableTwo;

    }

    return start + middle + end;
  }

  /**
   * Determines if the two animations can be played in the same animation.
   * @param a Animation to be compared
   * @return Whether or not the two animations are compatible
   */
  public boolean sameTime(AAnimation a) {

    if (!(a instanceof Scale)) {

      return true;

    } else {

      if (this.affected.equals(a.affected)) {

        return !(a.start < this.end || this.start < a.end);

      } else {

        return true;

      }

    }

  }

  /**
   * Returns the new x parameter
   */
  public int xParam() {
    return variableOne;
  }

  /**
   * Returns the new y parameter
   */
  public int yParam() {
    return variableTwo;
  }
}

