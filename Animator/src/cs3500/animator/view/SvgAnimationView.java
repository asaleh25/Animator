package cs3500.animator.view;

import cs3500.animator.model.AAnimation;
import cs3500.animator.model.AShape;
import cs3500.animator.model.ColorChange;
import cs3500.animator.model.EasyAnimatorOperations;
import cs3500.animator.model.Move;
import cs3500.animator.model.Oval;
import cs3500.animator.model.Rectangle;
import cs3500.animator.model.Scale;

public class SvgAnimationView implements IView<String, AShape, AAnimation> {
  private int tickRate;
  private int animationWidth;
  private int animationtHeight;

  /**
   * Default constructor, sets the animation to be 500x500.
   * @param tickRate the desired speed of the animation
   */
  public SvgAnimationView(int tickRate) {
    this.tickRate = tickRate;
    this.animationWidth = 500;
    this.animationtHeight = 500;
  }

  public SvgAnimationView(int animationWidth, int animationtHeight, int tickRate) {
    this.tickRate = tickRate;
    this.animationtHeight = animationtHeight;
    this.animationWidth = animationWidth;
  }

  /**
   * Converts ticks to milliseconds using the tick rate of the animation
   * @param tick the current tick
   * @return the millisecond corresponding to the current tick.
   */
  @Override
  public int convertTicks(int tick) {
    return (tick / this.tickRate) * 1000;
  }

  @Override
  public String render(EasyAnimatorOperations<AShape, AAnimation> model) {
    StringBuilder result = new StringBuilder();
    result.append("svg width=\"%f\" height=\"%f\" version\"1.1\"" +
            "xmlns=\"http://www.w3.org/2000/svg\"");
    for (AShape s : model.getShapes()) {
      if (s instanceof Rectangle) {
        Rectangle r = (Rectangle) s;
        result.append(String.format("\n<rect id=\"%s\" x=\"%f\" y=\"%f\" width=\"%f\" " +
                "height=\"%f\" fill=\"rgb%s\" visibility=\"visible\"\n", r.getName(),
                r.getLLC().getX(), r.getLLC().getY(), r.getWidth(), r.getHeight(),
                r.getColor().toString()));
        for (AAnimation a : model.getAnimations()) {
          if (a.getAffected().getName().equals(r.getName())) {
            if(a instanceof Move) {
              Move m = (Move) a;
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"x\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(m.getStart()),
                      convertTicks(m.duration()), r.getLLC().getX(), m.endLocation().getX()));
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"y\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(m.getStart()),
                      convertTicks(m.duration()), r.getLLC().getY(), m.endLocation().getY()));
            }
            else if (a instanceof Scale) {
              Scale sc = (Scale) a;
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"width\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(sc.getStart()),
                      convertTicks(sc.duration()), r.getWidth(), sc.xParam()));
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"height\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(sc.getStart()),
                      convertTicks(sc.duration()), r.getHeight(), sc.yParam()));
            }
            else if (a instanceof ColorChange) {
              ColorChange cc = (ColorChange) a;
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"fill\" from=\"rgb%s\" to=\"rgb%s\" " +
                              "fill=\"freeze\" /\n", convertTicks(cc.getStart()),
                      convertTicks(cc.duration()), r.getColor(), cc.getNewColor().toString()));
            }
          }
          else {
            continue;
          }
        }
        result.append("</rect>\n");
      }
      else if (s instanceof Oval) {
        Oval c = (Oval) s;
        result.append(String.format("\n<ellipse id=\"%s\" cx=\"%f\" cy=\"%f\" rx=\"%f\" " +
                        "ry=\"%f\" fill=\"rgb%s\" visibility=\"visible\"", c.getName(),
                c.getCenter().getX(), c.getCenter().getY(), c.getxRadius(), c.getyRadius(),
                c.getColor().toString()));
        for (AAnimation a : model.getAnimations()) {
          if (a.getAffected().getName().equals(s.getName())) {
            if(a instanceof Move) {
              Move m = (Move) a;
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"cx\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(m.getStart()),
                      convertTicks(m.duration()), c.getCenter().getX(), m.endLocation().getX()));
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"cy\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(m.getStart()),
                      convertTicks(m.duration()), c.getCenter().getY(), m.endLocation().getY()));
            }
            else if (a instanceof Scale) {
              Scale sc = (Scale) a;
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"rx\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(sc.getStart()),
                      convertTicks(sc.duration()), c.getxRadius(), sc.xParam()));
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"ry\" from=\"%f\" to=\"%f\" " +
                              "fill=\"freeze\" /\n", convertTicks(sc.getStart()),
                      convertTicks(sc.duration()), c.getyRadius(), sc.yParam()));
            }
            else if (a instanceof ColorChange) {
              ColorChange cc = (ColorChange) a;
              result.append(String.format("<animate attributeType=\"xml\" begin=\"%fms\" " +
                              "dur=\"%fms\" attributeName=\"fill\" from=\"rgb%s\" to=\"rgb%s\" " +
                              "fill=\"freeze\" /\n", convertTicks(cc.getStart()),
                      convertTicks(cc.duration()), c.getColor(), cc.getNewColor().toString()));
            }
          }
          else {
            continue;
          }
        }
        result.append("</ellipse>\n");
      }
    }
    result.append("</svg>");
    return result.toString();
  }
}
