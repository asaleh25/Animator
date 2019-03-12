package cs3500.animator.model;

/**
 * To represent the animation color change.
 */
public class ColorChange extends AAnimation {

  private MyColor newColor;

  /**
   * Creates a colorChange.
   *
   * @param affected affected shape
   * @param start    start time
   * @param end      end time
   * @param newColor new color
   */
  public ColorChange(AShape affected, int start, int end, MyColor newColor) {

    super(affected, start, end);
    this.newColor = newColor;

  }

  @Override
  public boolean equals(Object o) {

    if (o instanceof ColorChange) {

      ColorChange temp = (ColorChange) o;
      return temp.affected.equals(this.affected) && temp.start == this.start &&
              this.end == temp.end && this.newColor.equals(temp.newColor);

    } else {

      return false;

    }

  }

  @Override
  public int hashCode() {

    return this.affected.hashCode() + start + end + newColor.hashCode();

  }

  @Override
  public String toString() {

    String start = "Shape " + this.affected.getName() + " changes color from ";
    String end = " from t=" + this.start + " to t=" + this.end;
    String middle = "" + this.affected.getColor().toString() + " to " +
            this.newColor.toString();

    return start + middle + end;

  }

  /**
   * Determines if the two animations can be in the same animation.
   * @param a animation to be compared
   * @return whether or not the two animations are compatible.
   */
  public boolean sameTime(AAnimation a) {

    if (!(a instanceof ColorChange)) {

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
   * Returns the new color
   */
  public MyColor getNewColor() {
    return new MyColor(this.newColor);
  }
}
