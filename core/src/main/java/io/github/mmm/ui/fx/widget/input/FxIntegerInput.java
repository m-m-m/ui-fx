/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.input.UiIntegerInput;
import javafx.scene.control.TextField;

/**
 * Implementation of {@link UiIntegerInput} using JavaFx {@link TextField}.
 *
 * @since 1.0.0
 */
public class FxIntegerInput extends FxNumberInput<Integer> implements UiIntegerInput {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxIntegerInput(UiContext context) {

    super(context);
  }

  @Override
  protected NumberType<Integer> getNumberType() {

    return NumberType.INTEGER;
  }

}
