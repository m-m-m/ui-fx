/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.window;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.datatype.UiEnabledFlags;
import io.github.mmm.ui.api.widget.panel.UiButtonPanel;
import io.github.mmm.ui.api.widget.window.UiPopup;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Implementation of {@link UiPopup} using JavaFx {@link Popup}.
 *
 * @since 1.0.0
 */
public class FxPopup extends FxChildWindow implements UiPopup {

  private final UiButtonPanel buttonPanel;

  /**
   * The constructor.
   *
   * @param context the {@link UiContext}.
   */
  public FxPopup(UiContext context) {

    super(context, new Stage());
    this.widget.initModality(Modality.APPLICATION_MODAL);
    this.buttonPanel = UiButtonPanel.of(context);
    this.composite.getChildren().add(getTopNode(this.buttonPanel));
  }

  @Override
  protected boolean isScrollable() {

    return false;
  }

  @Override
  public UiButtonPanel getButtonPanel() {

    return this.buttonPanel;
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    super.setEnabledNative(enabled);
    this.buttonPanel.setEnabled(enabled, UiEnabledFlags.PARENT);
  }

}
