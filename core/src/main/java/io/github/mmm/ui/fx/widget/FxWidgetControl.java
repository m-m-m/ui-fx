/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.widget.UiWidget;
import javafx.scene.control.Control;

/**
 * Implementation of {@link UiWidget} for JavaFx based on {@link Control}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetControl<W extends Control> extends FxWidgetNode<W> {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidgetControl(W widget) {

    super(widget);
  }

  @Override
  protected void setTooltipNative(String newTooltip) {

    setTooltip(this.widget, newTooltip);
  }

}
