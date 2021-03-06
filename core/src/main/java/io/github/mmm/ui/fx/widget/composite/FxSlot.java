/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.composite;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.composite.UiSlot;
import javafx.scene.layout.StackPane;

/**
 * Implementation of {@link UiSlot} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxSlot extends FxComposite<StackPane, UiRegularWidget> implements UiSlot {

  private UiRegularWidget child;

  /**
   * The constructor.
   */
  public FxSlot() {

    super(new StackPane());
  }

  @Override
  public UiRegularWidget getChild() {

    return this.child;
  }

  @Override
  public void setChild(UiRegularWidget child) {

    if (this.child == child) {
      return;
    }
    if (this.child != null) {
      this.widget.getChildren().clear();
      setParent(this.child, null);
    }
    this.widget.getChildren().add(getTopNode(child));
    this.child = child;
    setParent(this.child, this);
  }

}
