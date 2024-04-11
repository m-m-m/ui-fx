package io.github.mmm.ui.fx.widget.number;

import java.math.BigInteger;

import io.github.mmm.base.number.NumberType;

/**
 * {@link FxNumberSpinnerValueFactory} for {@link BigInteger}.
 */
public class FxBigIntegerSpinnerValueFactory extends FxNumberSpinnerValueFactory<BigInteger> {

  FxBigIntegerSpinnerValueFactory() {

    super(NumberType.BIG_INTEGER, null, null);
  }

}