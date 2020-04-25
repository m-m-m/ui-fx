/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import javafx.scene.control.Tooltip;

/**
 * JavaFx widget that shows a validation failure box as popup/popover on an invalid widget.
 *
 * @since 1.0.0
 */
public class FxValidationFailureBox extends Tooltip {

  /** The {@link #getStyleClass() style class}. */
  public static final String STYLE_CLASS = "ui-validation-failure";

  /**
   * The constructor.
   */
  public FxValidationFailureBox() {

    super();
    setAutoFix(true);
    getStyleClass().add(STYLE_CLASS);
    setAnchorLocation(AnchorLocation.WINDOW_TOP_RIGHT);
  }

}
