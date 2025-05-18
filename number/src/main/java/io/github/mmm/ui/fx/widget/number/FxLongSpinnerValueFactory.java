package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.base.number.NumberType;

/**
 * {@link FxNumberSpinnerValueFactory} for {@link Long}.
 */
class FxLongSpinnerValueFactory extends FxNumberSpinnerValueFactory<Long> {

  FxLongSpinnerValueFactory() {

    super(NumberType.LONG, Long.MIN_VALUE, Long.MAX_VALUE);
  }

}