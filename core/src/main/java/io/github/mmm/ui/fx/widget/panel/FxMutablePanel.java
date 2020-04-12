/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiMutablePanel;
import io.github.mmm.ui.fx.widget.composite.FxMutableCompositePane;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiMutablePanel} using JavaFx {@link Pane}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxMutablePanel<W extends Pane> extends FxMutableCompositePane<W, UiRegularWidget>
    implements UiMutablePanel {

  /**
   * The constructor.
   * 
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxMutablePanel(W widget) {

    super(widget);
  }

}
