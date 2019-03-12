package cs3500.animator.model;

import java.util.List;

public interface EasyAnimatorOperations<T, U> {
  List<T> getShapes();

  List<U> getAnimations();

  boolean animationStarted();

  /**
   * Calculates the current time frame.
   * @return an integer representation of the current time frame of the implementation of the
   * animation.
   */
  int currentTick();

  /**
   * Updates the current time to move to the next frame.
   */
  void updateTick();

  /**
   * Starts the animator by setting hasAnimatorStarted to true.
   */
  void startAnimator();

  /**
   * Adds a shape to the animation.
   * @param shape Shape to be added
   */
  void addShape(T shape);

  /**
   * Removes the given shape from the animation.
   * @param shape Shape to be removed
   * @throws IllegalArgumentException if shape is not part of the animation
   */
  void removeShape(T shape);

  /**
   * Adds an animation to the animation.
   * @param anim Animation to be added
   */
  void addAnimation(U anim);

  /**
   * Removes an animation from the animation.
   * @param anim animation to be removed
   * @throws IllegalArgumentException if animation is not part of the animation
   */
  void removeAnimation(U anim);

  /**
   * Gets the animation state for the current animation.
   * @return Animation State
   */
  String getAnimatorState();

}