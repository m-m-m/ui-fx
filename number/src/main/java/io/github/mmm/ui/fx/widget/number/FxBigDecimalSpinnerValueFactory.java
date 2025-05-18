package io.github.mmm.ui.fx.widget.number;

import java.math.BigDecimal;

import io.github.mmm.base.number.NumberType;

/**
 * {@link FxNumberSpinnerValueFactory} for {@link BigDecimal}.
 */
public class FxBigDecimalSpinnerValueFactory extends FxNumberSpinnerValueFactory<BigDecimal> {

  FxBigDecimalSpinnerValueFactory() {

    super(NumberType.BIG_DECIMAL, null, null);
  }

}