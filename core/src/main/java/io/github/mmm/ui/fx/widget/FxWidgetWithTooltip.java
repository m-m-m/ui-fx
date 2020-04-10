/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.attribute.AttributeWriteTooltip;
import io.github.mmm.ui.api.widget.UiWidget;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;

/**
 * Implementation of {@link UiWidget} for JavaFx {@link Node}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetWithTooltip<W extends Node> extends FxWidgetNode<W> implements AttributeWriteTooltip {

  private Tooltip fxTooltip;

  /**
   * The constructor.
   * 
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidgetWithTooltip(W widget) {

    super(widget);
  }

  @Override
  public String getTooltip() {

    if (this.fxTooltip == null) {
      return "";
    } else {
      return this.fxTooltip.getText();
    }
  }

  @Override
  public void setTooltip(String tooltip) {

    if (this.fxTooltip == null) {
      this.fxTooltip = new Tooltip();
      Tooltip.install(this.widget, this.fxTooltip);
    }
    this.fxTooltip.setText(tooltip);
  }

}
