package cs3500.hw05.oldModel;

public class Square extends Rectangle {

  public Square(String name, Position2D posn, double length, MyColor color) {
    super(name, posn, length, length, color);
  }

  @Override
  public void resize(int t, double x, double y) {
    double vel = (x - this.width) / t;
    this.width += vel;
    this.height += vel;
  }
}
