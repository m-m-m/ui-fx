/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.event.UiClickEvent;
import io.github.mmm.ui.api.widget.UiActiveWidget;
import io.github.mmm.ui.api.widget.UiClickableWidget;
import javafx.scene.control.Control;

/**
 * Implementation of {@link UiActiveWidget} based on JavaFx {@link Control}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxClickableWidget<W extends Control> extends FxActiveWidget<W> implements UiClickableWidget {

  /**
   * The constructor.
   * 
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxClickableWidget(W widget) {

    super(widget);
  }

  @Override
  public void click() {

    fireEvent(new UiClickEvent(this, true));
  }

}
