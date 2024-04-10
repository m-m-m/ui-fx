/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.number.UiIntegerInput;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;

/**
 * Implementation of {@link UiIntegerInput} for JavaFx as {@link FxSpinner}.
 *
 * @since 1.0.0
 */
public class FxIntegerSpinner extends FxSpinner<Integer> implements UiIntegerInput {

  private final IntegerSpinnerValueFactory factory;

  /**
   * The constructor.
   */
  public FxIntegerSpinner() {

    this(new IntegerSpinnerValueFactory(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 1));
    this.factory.setValue(null);
  }

  private FxIntegerSpinner(IntegerSpinnerValueFactory factory) {

    super(factory);
    this.factory = factory;
  }

  @Override
  protected NumberType<Integer> getNumberType() {

    return NumberType.INTEGER;
  }

  @Override
  public Integer getStep() {

    return Integer.valueOf(this.factory.getAmountToStepBy());
  }

  @Override
  public void setStep(Integer step) {

    if (step != null) {
      this.factory.setAmountToStepBy(step.intValue());
    }
  }

}
