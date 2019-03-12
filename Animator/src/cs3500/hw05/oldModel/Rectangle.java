package cs3500.hw05.oldModel;

public class Rectangle extends GeometryObject {
  protected double width;
  protected double height;

  public Rectangle(String name, Position2D posn, double width, double height, MyColor color) {
    super(name, posn, color);
    this.height = height;
    this.width = width;
  }


  @Override
  public void resize(int t, double x, double y) {
    double xVel = (x - this.width) / t;
    double yVel = (y - this.height) / t;
    this.width += xVel;
    this.height += yVel;
  }
}
