/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.number;

import io.github.mmm.ui.api.widget.number.UiIntegerInput;

/**
 * Implementation of {@link UiIntegerInput} for JavaFx as {@link FxSpinner}.
 *
 * @since 1.0.0
 */
public class FxIntegerSpinner extends FxSpinner<Integer> implements UiIntegerInput {

  /**
   * The constructor.
   */
  public FxIntegerSpinner() {

    super(new FxIntegerSpinnerValueFactory());
  }

}
