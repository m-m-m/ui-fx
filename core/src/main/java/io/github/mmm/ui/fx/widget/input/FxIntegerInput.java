/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.datatype.UiValidState;
import io.github.mmm.ui.widget.input.UiIntegerInput;
import javafx.scene.control.TextField;

/**
 * Implementation of {@link UiIntegerInput} using JavaFx {@link TextField}.
 *
 * @since 1.0.0
 */
public class FxIntegerInput extends FxTextualInput<TextField, Integer> implements UiIntegerInput {

  /**
   * The constructor.
   *
   * @param context the {@link #getContext() context}.
   */
  public FxIntegerInput(UiContext context) {

    super(context, new TextField());
  }

  @Override
  public Integer getValue() {

    String value = this.widget.getText();
    if (isEmpty(value)) {
      return null;
    }
    // TODO validation
    try {
      return Integer.valueOf(value);
    } catch (NumberFormatException e) {
      return null;
    }
  }

  @Override
  public boolean validateDown(UiValidState state) {

    // TODO Auto-generated method stub
    return super.validateDown(state);
  }

  @Override
  protected void setValueNative(Integer value) {

    String text = "";
    if (value != null) {
      text = value.toString();
    }
    setText(text);
  }

}
