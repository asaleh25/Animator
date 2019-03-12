import org.junit.Test;

import cs3500.hw05.oldModel.GeometryObject;
import cs3500.hw05.oldModel.Oval;
import cs3500.hw05.oldModel.Position2D;
import cs3500.hw05.oldModel.Rectangle;
import cs3500.hw05.oldModel.MyColor;

import static org.junit.Assert.assertEquals;

public class GeometryObjectTest {

  @Test
  public void testUpdateLocation() {
    GeometryObject rectangle = new Rectangle("R", new Position2D(50, 50), 10, 5, new MyColor
            (1.0, 0.0, 0.0));

    rectangle.updateLocation(-10, 10);
    assertEquals(new Position2D(40, 60), rectangle.getLocation());
  }

  @Test
  public void testUpdateColor() {
    GeometryObject oval = new Oval("O", new Position2D(50, 100), 4, 8, new MyColor(0.0,
            0.0, 1.0));
    oval.updateColor(0.25, 0.25, -0.25);
    assertEquals(new MyColor(0.25, 0.25, 0.75), oval.getColor());
  }
}