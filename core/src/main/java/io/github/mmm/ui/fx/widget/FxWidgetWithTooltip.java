/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.attribute.AttributeWriteTooltip;
import io.github.mmm.ui.widget.UiWidget;
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
   * @param context the {@link #getContext() context}.
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidgetWithTooltip(UiContext context, W widget) {

    super(context, widget);
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
