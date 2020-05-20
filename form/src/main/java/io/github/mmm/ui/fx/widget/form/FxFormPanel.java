/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.form;

import io.github.mmm.ui.api.widget.form.UiFormPanel;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.fx.widget.composite.FxValuedComposite;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiFormPanel} for JavaFx.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class FxFormPanel<V> extends FxValuedComposite<VBox, UiAbstractInput<?>, V> implements UiFormPanel<V> {

  /**
   * The constructor.
   */
  public FxFormPanel() {

    super(new VBox());
    getStyles().add(STYLE);
  }

  @Override
  protected void addChildWidget(UiAbstractInput<?> child, int index) {

    int rows = this.children.size();
    Node topNode;
    if (child instanceof UiInput) {
      UiInput<?> input = (UiInput<?>) child;
      topNode = getTopNode(input.getContainerWidget());
    } else {
      topNode = getTopNode(child);
    }
    if ((index == -1) || (index == rows)) {
      this.widget.getChildren().add(topNode);
    } else if (index < rows) {
      this.widget.getChildren().add(index, topNode);
    }
  }

  @Override
  protected void removeChildWidget(UiAbstractInput<?> child, int index) {

    this.widget.getChildren().remove(index);
  }

}
