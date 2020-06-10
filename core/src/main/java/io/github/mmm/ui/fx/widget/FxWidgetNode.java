/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.widget.UiWidget;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;

/**
 * Implementation of {@link UiWidget} for JavaFx based on {@link Node}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxWidgetNode<W extends Node> extends FxWidgetStyleable<W> {

  private Tooltip fxTooltip;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxWidgetNode(W widget) {

    super(widget);
  }

  @Override
  public Node getTopWidget() {

    return this.widget;
  }

  @Override
  protected void setIdNative(String id) {

    getTopWidget().setId(id);
  }

  @Override
  protected void setTooltipNative(String newTooltip) {

    if (this.widget instanceof Control) {
      setTooltip((Control) this.widget, newTooltip);
    } else if (this.widget != null) {
      if (this.fxTooltip == null) {
        this.fxTooltip = new Tooltip();
        Tooltip.install(this.widget, this.fxTooltip);
      }
      this.fxTooltip.setText(newTooltip);
    }
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    Node topWidget = getTopWidget();
    if (topWidget != null) {
      topWidget.setVisible(visible);
      topWidget.setManaged(visible);
    }
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    if (this.widget != null) {
      this.widget.setDisable(!enabled);
    }
  }

  @Override
  protected void setReadOnlyNative(boolean readOnly) {

    if (this.widget != null) {
      this.widget.pseudoClassStateChanged(CLASS_READ_ONLY, readOnly);
    }
  }

}
