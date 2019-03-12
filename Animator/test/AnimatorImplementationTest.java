import org.junit.Test;

import cs3500.hw05.oldModel.AnimatorImplementation;

import static org.junit.Assert.*;

public class AnimatorImplementationTest {
  @Test
  public void testTime() {
    AnimatorImplementation testModel = new AnimatorImplementation();
    assertEquals(0, testModel.currentTime());
    testModel.updateTime();
    assertEquals(1, testModel.currentTime());
  }

}