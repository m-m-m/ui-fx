/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.input;

import io.github.mmm.ui.api.widget.input.UiTextArea;
import javafx.scene.control.TextArea;

/**
 * Implementation of {@link UiTextArea} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxTextArea extends FxStringInput<TextArea> implements UiTextArea {

  /**
   * The constructor.
   */
  public FxTextArea() {

    super(new TextArea());
  }

}
