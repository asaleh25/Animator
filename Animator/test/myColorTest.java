import org.junit.Test;

import cs3500.hw05.oldModel.MyColor;

import static org.junit.Assert.assertEquals;

public class myColorTest {

  @Test
  public void testRed() {
    MyColor testColor = new MyColor(0.5, 0.75,1.0);
    assertEquals(0.5, testColor.Red(), 0.01);

  }

  @Test
  public void testGreen() {
    MyColor testColor = new MyColor(0.5, 0.75,1.0);
    assertEquals(0.75, testColor.Green(), 0.01);
  }

  @Test
  public void testBlue() {
    MyColor testColor = new MyColor(0.5, 0.75,1.0);
    assertEquals(1.0, testColor.Blue(), 0.01);
  }

  @Test
  public void testToString()  {
    MyColor testColor = new MyColor(0.5, 0.75,1.0);
    String testString = testColor.toString();
    assertEquals("(0.50, 0.75, 1.00)", testString);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColor() {
    MyColor illegalColor = new MyColor(5.0, 0.4, 0.3);
  }
}