/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.api.event.UiHideEvent;
import io.github.mmm.ui.api.event.UiShowEvent;
import io.github.mmm.ui.api.widget.composite.UiComposite;
import io.github.mmm.ui.api.widget.window.UiAbstractWindow;
import io.github.mmm.ui.api.widget.window.UiChildWindow;
import io.github.mmm.ui.api.widget.window.UiPopup;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Implementation of {@link UiChildWindow} for JavaFx.
 *
 * @since 1.0.0
 */
public abstract class FxChildWindow extends FxAbstractWindow implements UiChildWindow {

  private boolean closable;

  private boolean movable;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxChildWindow(Stage widget) {

    super(widget);
    this.closable = true;
    this.movable = true;
  }

  @Override
  protected boolean isVisibleWithoutRoot() {

    return true;
  }

  @Override
  public UiAbstractWindow getParent() {

    return super.getParent();
  }

  @Override
  protected void setParent(UiComposite<?> parent) {

    assert ((parent == null) || (parent instanceof UiAbstractWindow));
    super.setParent(parent);
  }

  /**
   * @return {@code true} to use a {@link ScrollPane} and allow the content to scroll, {@code false} otherwise.
   */
  @Override
  protected boolean isScrollable() {

    return (this instanceof UiPopup);
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnHidden(this::onHidden);
    this.widget.setOnShown(this::onShown);
  }

  private void onHidden(WindowEvent event) {

    fireEvent(new UiHideEvent(this, getProgrammaticEventType() == UiHideEvent.TYPE));
  }

  private void onShown(WindowEvent event) {

    fireEvent(new UiShowEvent(this, getProgrammaticEventType() == UiShowEvent.TYPE));
  }

  @Override
  public boolean isClosable() {

    return this.closable;
  }

  @Override
  public void setClosable(boolean closable) {

    this.closable = closable;
  }

  @Override
  public boolean isMovable() {

    return this.movable;
  }

  @Override
  public void setMovable(boolean movable) {

    this.movable = movable;
  }

  @Override
  public void centerOnScreen() {

    this.positionAndSize.centerOnScreen(true);
  }

}
