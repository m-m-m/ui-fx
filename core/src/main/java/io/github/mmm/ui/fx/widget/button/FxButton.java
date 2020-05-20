/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.button;

import io.github.mmm.ui.api.widget.button.UiButton;
import javafx.scene.control.Button;

/**
 * Implementation of {@link UiButton} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxButton extends FxAbstractButton<Button> implements UiButton {

  /**
   * The constructor.
   */
  public FxButton() {

    super(new Button());
    getStyles().add(STYLE);
  }

}
