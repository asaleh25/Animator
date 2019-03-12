package cs3500.animator.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents the model for the EasyAnimator.
 */
public class EasyAnimatorModel implements EasyAnimatorOperations<AShape, AAnimation> {

  private boolean hasAnimationStarted;
  private ArrayList<AShape> shapes;
  private ArrayList<AAnimation> animations;
  private int tick;

  /**
   * Creates a new Easy Animator Model.
   */
  public EasyAnimatorModel() {

    this.hasAnimationStarted = false;
    this.shapes = new ArrayList<>();
    this.animations = new ArrayList<>();
  }

  @Override
  public List<AShape> getShapes() {
    return new ArrayList<AShape>(this.shapes);
  }

  @Override
  public List<AAnimation> getAnimations() {
    return new ArrayList<AAnimation>(this.animations);
  }

  @Override
  public boolean animationStarted() {
    return this.hasAnimationStarted;
  }

  @Override
  public int currentTick() {
    return this.tick;
  }

  @Override
  public void updateTick() {
    this.tick += 1;
  }

  @Override
  public void startAnimator() {

    this.hasAnimationStarted = true;
    this.tick = 0;

  }

  @Override
  public void addShape(AShape shape) {

    shapes.add(shape);

  }

  @Override
  public void removeShape(AShape shape) throws IllegalArgumentException {

    if (shapes.contains(shape)) {

      shapes.remove(shape);

    } else {

      throw new IllegalArgumentException("No such shape exists");

    }

  }

  @Override
  public void addAnimation(AAnimation anim) {


    if (!this.shapes.contains(anim.getAffected())) {

      throw new IllegalArgumentException("Shape doesn't exist");

    } else if (!anim.validAnim(this.animations)) {

      throw new IllegalArgumentException("Animation cannot function correctly with the others");

    } else {

      this.animations.add(anim);

    }

  }

  @Override
  public void removeAnimation(AAnimation anim) throws IllegalArgumentException {

    if (animations.contains(anim)) {

      animations.remove(anim);

    } else {

      throw new IllegalArgumentException("No such animation exists");

    }

  }

  @Override
  public String getAnimatorState() throws IllegalArgumentException {

    if (!this.hasAnimationStarted) {

      throw new IllegalArgumentException("Animation hasn't started");

    }
    String shape = "Shapes: \n";
    for (AShape shap : this.shapes) {

      shape = shape + shap.toString() + "\n\n";

    }

    for (AAnimation anim : this.animations) {

      shape = shape + anim.toString() + "\n";

    }

    return shape;
  }
}
