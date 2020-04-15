/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.widget.UiLabel;
import javafx.scene.control.Label;

/**
 * Implementation of {@link UiLabel} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxLabel extends FxWidgetControl<Label> implements UiLabel {

  /**
   * The constructor.
   */
  public FxLabel() {

    super(new Label());
  }

  @Override
  public String getText() {

    return this.widget.getText();
  }

  @Override
  public void setText(String text) {

    this.widget.setText(text);
  }

}
