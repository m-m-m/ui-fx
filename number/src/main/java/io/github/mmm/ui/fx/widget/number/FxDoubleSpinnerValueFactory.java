package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;

/**
 * {@link FxNumberSpinnerValueFactory} for {@link Double}.
 */
class FxDoubleSpinnerValueFactory extends FxNumberSpinnerValueFactory<Double> {

  FxDoubleSpinnerValueFactory() {

    super(NumberType.DOUBLE, Double.MIN_VALUE, Double.MAX_VALUE);
  }

}