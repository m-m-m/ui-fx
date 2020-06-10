/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.button;

import io.github.mmm.ui.api.widget.button.UiAbstractButton;
import io.github.mmm.ui.api.widget.img.UiAbstractImage;
import io.github.mmm.ui.fx.widget.FxClickableWidget;
import javafx.scene.control.ButtonBase;

/**
 * Implementation of {@link UiAbstractButton} for JavaFx.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractButton<W extends ButtonBase> extends FxClickableWidget<W> implements UiAbstractButton {

  private UiAbstractImage icon;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractButton(W widget) {

    super(widget);
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

  @Override
  public UiAbstractImage getImage() {

    return this.icon;
  }

  @Override
  public void setImage(UiAbstractImage icon) {

    this.icon = icon;
    this.widget.setGraphic(getTopNode(icon));
  }

}
