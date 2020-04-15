/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.widget.window.UiMainWindow;
import io.github.mmm.ui.api.widget.window.UiWindow;
import io.github.mmm.ui.fx.FxContext;
import javafx.scene.control.MenuBar;

/**
 * Implementation of {@link UiWindow} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxMainWindow extends FxAbstractWindow implements UiMainWindow {

  private MenuBar menuBar;

  /**
   * The constructor.
   */
  public FxMainWindow() {

    super(((FxContext) UiContext.get()).getPrimaryStage());
  }

  /**
   * @return the {@link MenuBar}.
   */
  public MenuBar getMenuBar() {

    if (this.menuBar == null) {
      this.menuBar = new MenuBar();
      this.composite.getChildren().add(0, this.menuBar);
    }
    return this.menuBar;
  }

  @Override
  protected int getChildOffset() {

    int offset = super.getChildOffset();
    if (this.menuBar != null) {
      offset++;
    }
    return offset;
  }

  @Override
  public boolean isWindowPositionAbsolute() {

    return true;
  }

}
