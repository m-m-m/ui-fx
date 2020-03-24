/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.fx.FxContext;
import io.github.mmm.ui.widget.menu.UiMenuBar;
import io.github.mmm.ui.widget.window.UiMainWindow;
import io.github.mmm.ui.widget.window.UiWindow;
import javafx.stage.Stage;

/**
 * Implementation of {@link UiWindow} using JavaFx {@link Stage}.
 *
 * @since 1.0.0
 */
public class FxMainWindow extends FxAbstractWindow implements UiMainWindow {

  private UiMenuBar menuBar;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   */
  public FxMainWindow(UiContext context) {

    super(context, ((FxContext) context).getPrimaryStage());
  }

  @Override
  public UiMenuBar getMenuBar() {

    if (this.menuBar == null) {
      this.menuBar = this.context.create(UiMenuBar.class);
      this.composite.getChildren().add(0, getTopNode(this.menuBar));
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
