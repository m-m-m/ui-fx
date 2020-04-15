/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.button;

import io.github.mmm.ui.api.widget.button.UiButton;
import io.github.mmm.ui.fx.widget.FxClickableWidget;
import javafx.scene.control.Button;

/**
 * Implementation of {@link UiButton} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxButton extends FxClickableWidget<Button> implements UiButton {

  /**
   * The constructor.
   */
  public FxButton() {

    super(new Button());
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnAction(this::onAction);
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
