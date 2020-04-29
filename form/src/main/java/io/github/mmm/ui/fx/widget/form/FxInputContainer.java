/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.form;

import io.github.mmm.ui.api.datatype.UiEnabledFlags;
import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.form.UiInputContainer;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import javafx.scene.layout.HBox;

/**
 * Implementation of {@link UiInputContainer} for JavaFx.
 *
 * @param <V> type of the {@link UiInput#getValue() input value}.
 * @since 1.0.0
 */
public class FxInputContainer<V> extends FxWidgetNode<HBox> implements UiInputContainer<V> {

  private UiInput<V> child;

  /**
   * The constructor.
   */
  public FxInputContainer() {

    super(new HBox());
  }

  @Override
  public UiInput<V> getChild() {

    return this.child;
  }

  @Override
  public void setChild(UiInput<V> child) {

    if (this.child != null) {
      throw new IllegalStateException();
    }
    this.child = child;
    UiLabel nameWidget = child.getNameWidget();
    this.widget.getChildren().add(getTopNode(nameWidget));
    setParent(nameWidget, this);
    this.widget.getChildren().add(getTopNode(child));
    setParent(child, this);
  }

  @Override
  protected void setEnabledNative(boolean enabled) {

    super.setEnabledNative(enabled);
    this.child.setEnabled(enabled, UiEnabledFlags.PARENT);
  }

}
