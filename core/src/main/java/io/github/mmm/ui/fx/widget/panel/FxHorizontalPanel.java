/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.panel.UiHorizontalPanel;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiHorizontalPanel} using JavaFx {@link HBox}.
 *
 * @since 1.0.0
 */
public class FxHorizontalPanel extends FxMutablePanel<HBox> implements UiHorizontalPanel {

  /**
   * The constructor.
   */
  public FxHorizontalPanel() {

    super(new HBox());
  }

}
