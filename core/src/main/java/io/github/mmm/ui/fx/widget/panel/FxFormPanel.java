/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.UiLabel;
import io.github.mmm.ui.api.widget.input.UiAbstractInput;
import io.github.mmm.ui.api.widget.input.UiInput;
import io.github.mmm.ui.api.widget.panel.UiFormPanel;
import io.github.mmm.ui.fx.widget.composite.FxValuedComposite;
import javafx.scene.Node;

/**
 * Implementation of {@link UiFormPanel} using JavaFx.
 *
 * @param <V> type of the {@link #getValue() value}.
 * @since 1.0.0
 */
public class FxFormPanel<V> extends FxValuedComposite<AdvancedGridPane, UiAbstractInput<?>, V>
    implements UiFormPanel<V> {

  /**
   * The constructor.
   */
  public FxFormPanel() {

    super(new AdvancedGridPane());
  }

  @Override
  protected void addChildWidget(UiAbstractInput<?> child, int index) {

    int rows = this.children.size();
    Node[] childNodes = null;
    if (child instanceof UiInput) {
      UiInput<?> input = (UiInput<?>) child;
      UiLabel label = input.getNameWidget();
      childNodes = new Node[] { getTopNode(label), getTopNode(child) };
    }
    if ((index == -1) || (index == rows)) {
      if (childNodes == null) {
        this.widget.add(getTopNode(child), 0, rows, 2, 1);
      } else {
        this.widget.addRow(rows, childNodes);
      }
    } else if (index < rows) {
      if (childNodes == null) {
        this.widget.insertRow(index, getTopNode(child));
      } else {
        this.widget.insertRow(index, childNodes);
      }
    }
  }

  @Override
  protected void removeChildWidget(UiAbstractInput<?> child, int index) {

    this.widget.removeRow(index);
  }

}
