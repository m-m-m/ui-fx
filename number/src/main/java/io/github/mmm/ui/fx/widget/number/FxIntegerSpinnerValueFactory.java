package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;

/**
 * {@link FxNumberSpinnerValueFactory} for {@link Integer}.
 */
class FxIntegerSpinnerValueFactory extends FxNumberSpinnerValueFactory<Integer> {

  FxIntegerSpinnerValueFactory() {

    super(NumberType.INTEGER, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

}