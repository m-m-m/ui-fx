/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.panel.UiVerticalPanel;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiVerticalPanel} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxVerticalPanel extends FxMutablePanel<VBox> implements UiVerticalPanel {

  /**
   * The constructor.
   */
  public FxVerticalPanel() {

    super(new VBox());
  }

}
