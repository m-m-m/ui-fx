/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.api.widget.window.UiWindow;
import javafx.stage.Stage;

/**
 * Implementation of {@link UiWindow} using JavaFx {@link Stage}.
 *
 * @since 1.0.0
 */
public class FxWindow extends FxChildWindow implements UiWindow {

  /**
   * The constructor.
   */
  public FxWindow() {

    super(new Stage());
  }

}
