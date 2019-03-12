package cs3500.animator.model;

/**
 * To Represent the Animation Move.
 */
public class Move extends AAnimation {

  private Posn to;

  /**
   * Creates a Move Animation.
   *
   * @param affected the affected shape
   * @param start    Start time of the move
   * @param end      End time of the move
   * @param to       Where the shape will end up
   */
  public Move(AShape affected, int start, int end, Posn to) {

    super(affected, start, end);
    this.to = to;

  }

  public Posn endLocation() {
    return new Posn(to);
  }

  @Override
  public boolean equals(Object o) {

    if (o instanceof Move) {

      Move temp = (Move) o;
      return this.affected.equals(temp.affected) && this.start == temp.start &&
              this.end == temp.end &&
              this.to.equals(temp.to);

    } else {

      return false;

    }

  }

  @Override
  public int hashCode() {

    return this.start + this.end +
            this.to.hashCode() + this.affected.hashCode();


  }

  @Override
  public String toString() {

    String start = "Shape " + this.affected.getName() + " moves from ";
    String end = " from t=" + this.start + " to t=" + this.end;
    String middle = "";

    if (this.affected instanceof Rectangle) {

      Rectangle rec = (Rectangle) this.affected;
      middle = rec.getLLC().toString() + " to " + this.to.toString();



    }
    if (this.affected instanceof Oval) {

      Oval ov = (Oval) this.affected;
      middle = ov.getCenter().toString() + " to " + this.to.toString();


    }

    return start + middle + end;

  }

  /**
   * Determines if the two animations can be used at the same time.
   * @param a to be compared to
   * @return Whether or not the two animations are compatible
   */
  public boolean sameTime(AAnimation a) {

    if (!(a instanceof Move)) {

      return true;

    } else {

      if (this.affected.equals(a.affected)) {

        return !(a.start < this.end || this.start < a.end);

      } else {

        return true;

      }

    }

  }

}

