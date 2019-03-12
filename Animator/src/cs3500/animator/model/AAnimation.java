package cs3500.animator.model;

import java.util.ArrayList;

/**
 * Abstract class for animations.
 */
public abstract class AAnimation {

  protected AShape affected;
  protected int start;
  protected int end;

  /**
   * Creates an AAnimation.
   *
   * @param affected affected shape
   * @param start    start time of animation
   * @param end      end time of animation
   */
  public AAnimation(AShape affected, int start, int end) {

    if (start < 0 || end < 0) {

      throw new IllegalArgumentException("Time can't be negative");

    }

    if (affected.starts() > this.start || affected.ends() < this.end) {

      throw new IllegalArgumentException("Animation must occur when shape is present");

    }
    this.affected = affected;
    this.start = start;
    this.end = end;


  }

  /**
   * Getter for affected.
   *
   * @return affected
   */
  public AShape getAffected() {

    return this.affected;

  }

  /**
   * Checks to see if this animation is compatible with the animations in arr.
   * @param arr List of animations
   * @return Whether or not this animation can be used
   */
  public boolean validAnim(ArrayList<AAnimation> arr) {

    for (AAnimation a : arr) {

      if (!a.canBeUsedAtSameTime(this)) {

        return false;

      }

    }

    return true;

  }

  /**
   * Determines if two animations can be played at the same time.
   *
   * @param a Animation to be compared
   */
  private boolean canBeUsedAtSameTime(AAnimation a) {

    if (this instanceof Move) {

      return ((Move)this).sameTime(a);

    } else if (this instanceof ColorChange) {

      return ((ColorChange)this).sameTime(a);

    } else if (this instanceof Scale) {

      return ((Scale)this).sameTime(a);

    } else {

      throw new IllegalArgumentException("Shape does not exist");

    }

  }

  /**
   * Returns the start time of the animation.
   * @return the start
   */
  public int getStart() {
    return start;
  }

  /**
   * Returns the duration of the animation.
   * @return the difference between the start and the end ticks
   */
  public int duration() {
    return end - start;
  }
}
