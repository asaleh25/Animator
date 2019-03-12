package cs3500.hw05.oldModel;

import java.util.Stack;

/**
 * Implementation of the animator operations interface provides methods to create and update
 * shapes, and track time.
 */
public class AnimatorImplementation implements AnimatorOperations {
  private int tick;
  private Stack<String> createStack;
  private Stack<String> callStack;

  public AnimatorImplementation() {
    this.tick = 0;
    this.createStack = new Stack<String>();
    this.callStack = new Stack<String>();
  }

  @Override
  public int currentTime() {
    return this.tick;
  }

  @Override
  public void updateTime() {
    this.tick += 1;
  }

  @Override
  public GeometryObject createShape(int startTime, int endTime, String name, double xComponent,
                                    double yComponent, Position2D loc, MyColor color, ShapeType
                                            shape) {
    StringBuilder create = new StringBuilder();
    GeometryObject newShape;
    create.append(String.format("\nName: %s\nType: %s", name, shape));
    switch (shape) {
      case OVAL:
        create.append(String.format("\nCenter: %s, X Radius: %f, Y Radius: %f, ", loc, xComponent,
                yComponent));
        newShape = new Oval(name, loc, xComponent, yComponent, color);
        break;
      case CIRCLE:
        create.append(String.format("\nCenter: %s, Radius: %f, ", loc, xComponent));
        newShape = new Circle(name, loc, xComponent, color);
        break;
      case RECTANGLE:
        create.append(String.format("\nLower-left corner: %s, Width: %f, Height: %f, ", loc,
                xComponent, yComponent));
        newShape = new Rectangle(name, loc, xComponent, yComponent, color);
        break;
      case SQUARE:
        create.append(String.format("\nLower-left corner: %s, Side length: %f, ", loc, xComponent));
        newShape = new Square(name, loc, xComponent, color);
        break;
      default:
        throw new IllegalArgumentException("Unrecognized shape.");
    }
    create.append(String.format("Color: %s\nAppears at t=%f\nDisappears at t=%f\n", color
            .toString(), startTime, endTime));
    this.createStack.push(create.toString());
    return newShape;
  }

  @Override
  public void move(int startTime, int endTime, GeometryObject shape, Position2D endLocation) {
    double xVelocity = shape.posn.xDistance(endLocation) / (endTime - startTime);
    double yVelocity = shape.posn.yDistance(endLocation) / (endTime - startTime);
    while (this.tick >= startTime && this.tick <= endTime) {
      shape.updateLocation(xVelocity, yVelocity);
      updateTime();
    }
    this.callStack.push(String.format("\nShape %s moves from %s to %s from t=%f to t=%f", shape
                    .name,
            shape.posn.toString(), endLocation.toString(), startTime, endTime));
  }

  @Override
  public void changeColor(int startTime, int endTime, GeometryObject shape, MyColor newColor) {
    MyColor oldColor = shape.color;
    double rVelocity = (newColor.Red() - oldColor.Red()) / (endTime - startTime);
    double gVelocity = (newColor.Green() - oldColor.Green()) / (endTime - startTime);
    double bVelocity = (newColor.Blue() - oldColor.Blue()) / (endTime - startTime);
    while (this.tick >= startTime && this.tick <= endTime) {
      shape.updateColor(rVelocity, gVelocity, bVelocity);
      updateTime();
    }
    this.callStack.push(String.format("\nShape %s changes color from %s to %s from t=%f to t=%f",
            shape.name, shape.color.toString(), newColor.toString(), startTime, endTime));
  }

  @Override
  public void scale(int startTime, int endTime, GeometryObject shape, double newXSize, double
          newYSize) {
    int timeSpan = endTime - startTime;
    while (this.tick <= endTime) {
      shape.resize(timeSpan, newXSize, newYSize);
      updateTime();
    }
    if (shape instanceof Rectangle) {
      Rectangle r = (Rectangle) shape;
      this.callStack.push(String.format("\nShape %s scales from Width: $f, Height: %f to Width: " +
                      "%f," + " Height: %f from t=$f to t=$f", r.name, r.width, r.height,
              newXSize, newYSize, startTime, endTime));
    } else if (shape instanceof Square) {
      Square s = (Square) shape;
      this.callStack.push(String.format("\nhape %s scales from Width: $f, Height: %f to Width: " +
                      "%f," +
                      " Height: %f from t=$f to t=$f", s.name, s.width, s.height, newXSize,
              newXSize, startTime, endTime));
    } else if (shape instanceof Oval) {
      Oval o = (Oval) shape;
      this.callStack.push(String.format("\nShape %s scales from X Radius: $f, Y Radius: %f to " +
                      "X Radius: %f, Y Radius: %f from t=$f to t=$f", o.name, o.xRadius, o.yRadius,
              newXSize, newYSize, startTime, endTime));
    } else if (shape instanceof Circle) {
      Circle c = (Circle) shape;
      this.callStack.push(String.format("\nShape %s scales from X Radius: $f, Y Radius: %f to "
                      + "X Radius: %f, Y Radius: %f from t=$f to t=$f", c.name, c.xRadius,
              c.yRadius, newXSize, newXSize, startTime, endTime));
    }
  }

  @Override
  public String toString() {
    StringBuilder animation = new StringBuilder();
    animation.append("Shapes:");

    while (!this.createStack.empty()) {
      animation.append(this.createStack.pop());
    }

    while(!this.callStack.empty()) {
      animation.append(this.callStack.pop());
    }

    return animation.toString();
  }
}
