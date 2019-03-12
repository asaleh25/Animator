package cs3500.animator.view;

import cs3500.animator.model.EasyAnimatorOperations;

public interface IView<T, U, V>{
  T render(EasyAnimatorOperations<U, V> model);

  int convertTicks(int tick);
}
