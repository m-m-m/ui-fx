/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.menubar;

import io.github.mmm.ui.api.event.UiClickEvent;
import io.github.mmm.ui.api.widget.menu.UiAbstractMenuItem;
import javafx.scene.control.MenuItem;

/**
 * Implementation of {@link UiAbstractMenuItem} for JavaFx and {@link FxMenuBar}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractMenuItem<W extends MenuItem> extends FxAbstractMenuEntry<W>
    implements UiAbstractMenuItem {

  private char accessKey;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractMenuItem(W widget) {

    super(widget);
  }

  /**
   * @return {@link io.github.mmm.ui.api.widget.UiActiveWidget#getAccessKey()}.
   */
  public char getAccessKey() {

    return this.accessKey;
  }

  /**
   * @param accessKey {@link io.github.mmm.ui.api.widget.UiActiveWidget#setAccessKey(char)}.
   */
  public void setAccessKey(char accessKey) {

    this.accessKey = accessKey;
  }

  /**
   * @see io.github.mmm.ui.api.widget.UiClickableWidget#click()
   */
  public void click() {

    fireEvent(new UiClickEvent(this, true));
  }

}
