package cs3500.animator.view;

import cs3500.animator.model.AAnimation;
import cs3500.animator.model.AShape;
import cs3500.animator.model.EasyAnimatorOperations;

public class TextualView implements IView<String, AShape, AAnimation> {

  private int tickRate;

  public TextualView(int tickRate) {
    this.tickRate = tickRate;
  }

  @Override
  public int convertTicks(int tick) {
    return tick / this.tickRate;
  }

  @Override
  public String render(EasyAnimatorOperations<AShape, AAnimation> model) {
      if (!model.animationStarted()) {

        throw new IllegalArgumentException("Animation hasn't started");

      }
      String shape = "Shapes: \n";
      for (AShape shap : model.getShapes()) {
        String temp = shap.toString();
        if(temp.contains("Rectangle")) {
          temp.replace("Lower-left corner", "Min-Corner");
        }
        shape = shape + temp + "\n\n";

      }

      for (AAnimation anim : model.getAnimations()) {

        String temp = anim.toString();
        int appTick = Integer.parseInt(temp.substring(temp.indexOf("=") + 1));
        int disTick = Integer.parseInt(temp.substring(temp.lastIndexOf("=") + 1));
        int appTime = convertTicks(appTick);
        int disTime = convertTicks(disTick);
        String firstHalf = temp.substring(0, temp.indexOf("="));
        String secondHalf = temp.substring(temp.indexOf("=") + 1);
        secondHalf.replace(Integer.toString(appTick), Integer.toString(appTime));
        secondHalf.replace(Integer.toString(disTick), Integer.toString(disTime));
        shape = shape + firstHalf + secondHalf + "\n";

      }

      return shape;
    }
}
