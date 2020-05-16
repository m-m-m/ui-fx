/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.widget.UiAtomicWidget;
import io.github.mmm.ui.spi.widget.UiNativeWidgetWrapper;
import javafx.scene.control.Control;
import javafx.scene.control.Tooltip;

/**
 * Implementation of {@link UiAtomicWidget} for JavaFx as interface based on {@link Control}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public interface FxAtomicWidgetMixin<W extends Control> extends UiNativeWidgetWrapper<W>, UiAtomicWidget {

  @Override
  default String getTooltip() {

    Tooltip tooltip = getWidget().getTooltip();
    if (tooltip != null) {
      String text = tooltip.getText();
      if (text != null) {
        return text;
      }
    }
    return "";
  }

  @Override
  default void setTooltip(String tooltip) {

    setTooltip(getWidget(), tooltip);
  }

  /**
   * @param widget the {@link Control} where to apply the tooltip to.
   * @param tooltip the tooltip text to apply.
   */
  static void setTooltip(Control widget, String tooltip) {

    Tooltip fxTooltip = widget.getTooltip();
    if (fxTooltip == null) {
      fxTooltip = new Tooltip(tooltip);
      widget.setTooltip(fxTooltip);
    } else {
      fxTooltip.setText(tooltip);
    }
  }

}
