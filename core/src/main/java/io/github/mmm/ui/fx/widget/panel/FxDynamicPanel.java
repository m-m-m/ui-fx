/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiDynamicPanel;
import io.github.mmm.ui.fx.widget.composite.FxDynamicCompositePane;
import javafx.scene.layout.Pane;

/**
 * Implementation of {@link UiDynamicPanel} using JavaFx {@link Pane}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxDynamicPanel<W extends Pane> extends FxDynamicCompositePane<W, UiRegularWidget>
    implements UiDynamicPanel {

  /**
   * The constructor.
   * 
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxDynamicPanel(W widget) {

    super(widget);
  }

}
