/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;
import io.github.mmm.ui.api.widget.number.UiDoubleInput;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;

/**
 * Implementation of {@link UiDoubleInput} for JavaFx as {@link FxSpinner}.
 *
 * @since 1.0.0
 */
public class FxDoubleSpinner extends FxSpinner<Double> implements UiDoubleInput {

  private final DoubleSpinnerValueFactory factory;

  /**
   * The constructor.
   */
  public FxDoubleSpinner() {

    this(new DoubleSpinnerValueFactory(Double.MIN_VALUE, Double.MAX_VALUE, 0, 1));
    this.factory.setValue(null);
  }

  private FxDoubleSpinner(DoubleSpinnerValueFactory factory) {

    super(factory);
    this.factory = factory;
  }

  @Override
  protected NumberType<Double> getNumberType() {

    return NumberType.DOUBLE;
  }

  @Override
  public Double getStep() {

    return Double.valueOf(this.factory.getAmountToStepBy());
  }

  @Override
  public void setStep(Double step) {

    if (step != null) {
      this.factory.setAmountToStepBy(step.doubleValue());
    }
  }

}
