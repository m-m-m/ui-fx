/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.widget.input.UiTextInput;
import javafx.scene.control.TextField;

/**
 * Implementation of {@link UiTextInput} using JavaFx {@link TextField}.
 *
 * @since 1.0.0
 */
public class FxTextInput extends FxStringInput<TextField> implements UiTextInput {

  /**
   * The constructor.
   */
  public FxTextInput() {

    super(new TextField());
  }

}
