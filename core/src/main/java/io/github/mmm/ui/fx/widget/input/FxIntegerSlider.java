/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.input.UiIntegerSlider;
import javafx.scene.control.Slider;

/**
 * Implementation of {@link UiIntegerSlider} using JavaFx {@link Slider}.
 *
 * @since 1.0.0
 */
public class FxIntegerSlider extends FxSlider<Integer> implements UiIntegerSlider {

  /**
   * The constructor.
   */
  public FxIntegerSlider() {

    super();
  }

  @Override
  protected NumberType<Integer> getNumberType() {

    return NumberType.INTEGER;
  }

}
