/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.ui.api.widget.number.UiLongInput;

/**
 * Implementation of {@link UiLongInput} for JavaFx as {@link FxSpinner}.
 *
 * @since 1.0.0
 */
public class FxLongSpinner extends FxSpinner<Long> implements UiLongInput {

  /**
   * The constructor.
   */
  public FxLongSpinner() {

    super(new FxLongSpinnerValueFactory());
  }

}
