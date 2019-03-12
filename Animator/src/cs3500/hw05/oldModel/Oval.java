package cs3500.hw05.oldModel;

public class Oval extends GeometryObject {
  protected double xRadius;
  protected double yRadius;

  public Oval(String name, Position2D posn, double xRadius, double yRadius, MyColor color) {
    super(name, posn, color);
    this.xRadius = xRadius;
    this.yRadius = yRadius;
  }


  @Override
  public void resize(int t, double x, double y) {
    double xVel = (x - this.xRadius) / t;
    double yVel = (y - this.yRadius) / t;
    this.xRadius += xVel;
    this.yRadius += yVel;
  }
}
