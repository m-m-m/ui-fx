/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.widget.input.UiStringInput;
import javafx.scene.control.TextInputControl;

/**
 * Implementation of {@link UiStringInput} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxStringInput<W extends TextInputControl> extends FxTextualInput<W, String>
    implements UiStringInput {

  /**
   * The constructor.
   *
   * @param nativeWidget the {@link #getWidget() JavaFx widget}.
   */
  public FxStringInput(W nativeWidget) {

    super(nativeWidget);
  }

  @Override
  public String getValueOrThrow() {

    return this.widget.getText();
  }

  @Override
  public void setValueNative(String value) {

    setText(value);
  }

}
