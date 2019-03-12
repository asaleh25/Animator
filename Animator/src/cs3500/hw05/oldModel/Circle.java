package cs3500.hw05.oldModel;

public class Circle extends Oval {

  public Circle(String name, Position2D posn, double radius, MyColor color) {
    super(name, posn, radius, radius, color);
  }

  @Override
  public void resize(int t, double x, double y) {
    double vel = (x - this.xRadius) / t;
    this.xRadius += vel;
    this.yRadius += vel;
  }
}
