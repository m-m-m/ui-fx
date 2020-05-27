/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiGridPanel;
import io.github.mmm.ui.api.widget.panel.UiGridRow;
import io.github.mmm.ui.fx.widget.composite.FxComposite;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Implementation of {@link UiGridPanel} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxGridPanel extends FxComposite<AdvancedGridPane, UiGridRow> implements UiGridPanel {

  /**
   * The constructor.
   */
  public FxGridPanel() {

    super(new AdvancedGridPane());
  }

  @Override
  public UiGridRow addRow(int rowIndex, UiRegularWidget... childWidgets) {

    FxGridRow row = new FxGridRow(this);
    setParent(row, this);
    if (rowIndex == -1) {
      this.children.add(row);
    } else {
      this.children.add(rowIndex, row);
      this.widget.insertRow(rowIndex);
    }
    if (childWidgets != null) {
      for (UiRegularWidget child : childWidgets) {
        row.addChild(child);
      }
    }
    return row;
  }

  @Override
  public UiGridRow removeChild(int index) {

    UiGridRow child = this.children.remove(index);
    this.widget.removeRow(index);
    setParent(child, null);
    return child;
  }

  void addChildWidget(UiRegularWidget child, UiGridRow row, int index, int colspan, int rowspan) {

    int rowIndex = this.children.indexOf(row);
    if (rowIndex < 0) {
      // grid row has already been removed...
      return;
    }
    int colIndex = 0;
    int colCount = row.getChildCount();
    int colLimit = index;
    if (colLimit == -1) {
      colLimit = colCount;
    }
    for (int i = 0; i < colLimit; i++) {
      Node node = getTopNode(row.getChild(i));
      Integer columnSpan = GridPane.getColumnSpan(node);
      if (columnSpan == null) {
        colIndex++;
      } else {
        colIndex += columnSpan.intValue();
      }
    }
    this.widget.add(getTopNode(child), colIndex, rowIndex, colspan, rowspan);
  }

  /**
   * @param child the child widget to remove.
   * @param index the index of the child.
   */
  public void removeChildWidget(UiRegularWidget child, int index) {

    this.widget.getChildren().remove(getTopNode(child));
  }

}
