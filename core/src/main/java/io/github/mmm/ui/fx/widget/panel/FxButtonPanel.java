/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.button.UiAbstractButton;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.fx.widget.composite.FxMutableCompositePane;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiButtonPanel} using JavaFx {@link HBox}.
 *
 * @since 1.0.0
 */
public class FxButtonPanel extends FxMutableCompositePane<HBox, UiAbstractButton> implements UiButtonPanel {

  /**
   * The constructor.
   */
  public FxButtonPanel() {

    super(new HBox());
  }

}
