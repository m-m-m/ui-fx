/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.datatype.UiVisibleFlags;
import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiGridRow;
import io.github.mmm.ui.fx.widget.composite.FxComposite;
import javafx.scene.Group;

/**
 * Implementation of {@link UiGridRow} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxGridRow extends FxComposite<Group, UiRegularWidget> implements UiGridRow {

  private final FxGridPanel grid;

  /**
   * The constructor.
   *
   * @param grid the owning {@link FxGridPanel}.
   */
  public FxGridRow(FxGridPanel grid) {

    super(new Group()); // dummy parent - never really used
    this.grid = grid;
  }

  @Override
  public void setChild(UiRegularWidget child, int column, int colspan, int rowspan) {

    this.grid.setChildWidget(child, this, column, colspan, rowspan);
    int size = this.children.size();
    if (child == null) {
      if (column == (size - 1)) { // last column removed?
        int i = column;
        while ((i >= 0) && (this.children.get(i) == null)) {
          this.children.remove(i);
          i--;
        }
      }
    } else {
      setParent(child, this);
      for (int i = size; i <= column; i++) {
        this.children.add(null);
      }
      this.children.set(column, child);
    }
  }

  @Override
  public UiRegularWidget removeChild(int index) {

    UiRegularWidget child = this.children.remove(index);
    this.grid.removeChildWidget(child, index);
    setParent(child, null);
    return child;
  }

  @Override
  protected void setVisibleNative(boolean visible) {

    for (UiRegularWidget child : this.children) {
      if (child != null) {
        child.setVisible(visible, UiVisibleFlags.PARENT);
      }
    }
  }

}
