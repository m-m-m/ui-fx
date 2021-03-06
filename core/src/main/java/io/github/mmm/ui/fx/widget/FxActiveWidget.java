/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget;

import io.github.mmm.ui.api.event.UiFocusGainEvent;
import io.github.mmm.ui.api.widget.UiActiveWidget;
import io.github.mmm.ui.api.widget.composite.UiComposite;
import javafx.scene.control.Control;
import javafx.scene.layout.Region;

/**
 * Implementation of {@link UiActiveWidget} based on JavaFx {@link Control}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxActiveWidget<W extends Region> extends FxWidgetNode<W> implements UiActiveWidget {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxActiveWidget(W widget) {

    super(widget);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    registerFocusChangeHandler();
  }

  /**
   * @see #registerHandlers()
   */
  protected void registerFocusChangeHandler() {

    this.widget.focusedProperty().addListener(this::onFocusChange);
  }

  @Override
  protected void setParent(UiComposite<?> parent) {

    if (parent != null) {
      ensureHandlers();
    }
    super.setParent(parent);
  }

  @Override
  public char getAccessKey() {

    // TODO
    return ACCESS_KEY_NONE;
  }

  @Override
  public void setAccessKey(char accessKey) {

    // TODO Auto-generated method stub

  }

  @Override
  public boolean isFocused() {

    return this.widget.isFocused();
  }

  @Override
  public boolean setFocused() {

    setProgrammaticEventType(UiFocusGainEvent.TYPE);
    this.widget.requestFocus();
    return true;
  }

}
