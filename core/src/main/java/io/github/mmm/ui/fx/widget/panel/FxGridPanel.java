/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import io.github.mmm.ui.api.widget.UiRegularWidget;
import io.github.mmm.ui.api.widget.panel.UiGridPanel;
import io.github.mmm.ui.api.widget.panel.UiGridRow;
import io.github.mmm.ui.fx.widget.composite.FxComposite;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

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
    // this.widget.setGridLinesVisible(true);
    getStyles().add(STYLE);
  }

  @Override
  public UiGridRow addRow(int rowIndex) {

    FxGridRow row = new FxGridRow(this);
    if (rowIndex == -1) {
      this.children.add(row);
    } else {
      this.children.add(rowIndex, row);
      this.widget.insertRow(rowIndex);
    }
    setParent(row, this);
    return row;
  }

  @Override
  public UiGridRow removeChild(int index) {

    UiGridRow child = this.children.remove(index);
    this.widget.removeRow(index);
    setParent(child, null);
    return child;
  }

  private int getColumnIndexWithRowspans(int columnIndex, int rowIndex) {

    int columns = columnIndex;
    for (int y = 0; y < rowIndex; y++) {
      UiGridRow row = this.children.get(y);
      int col = 0;
      for (int x = 0; col <= columnIndex; x++) {
        UiRegularWidget child = row.getChild(x);
        if (child == null) {
          break;
        }
        Node cell = getCellNode(child);
        int rowSpan = AdvancedGridPane.getRowSpanning(cell);
        if (rowSpan > (rowIndex - y)) {
          int colSpan = AdvancedGridPane.getColumnSpanning(cell);
          columns += colSpan;
        }
      }
    }
    return columns;
  }

  void addChildWidget(UiRegularWidget child, UiGridRow row, int index, int colspan, int rowspan) {

    int rowIndex = this.children.indexOf(row);
    if (rowIndex < 0) {
      // grid row has already been removed...
      return;
    }
    int columnIndex = 0;
    for (int i = 0; i < index; i++) {
      UiRegularWidget cellChild = row.getChild(i);
      int colSpan = AdvancedGridPane.getColumnSpanning(getCellNode(cellChild));
      columnIndex += colSpan;
    }
    columnIndex = getColumnIndexWithRowspans(columnIndex, rowIndex);
    this.widget.add(getCellNode(child), columnIndex, rowIndex, colspan, rowspan);
  }

  private static Node getCellNode(UiRegularWidget uiWidget) {

    return getCellNode(uiWidget, false);
  }

  private static Node getCellNode(UiRegularWidget uiWidget, boolean remove) {

    Node node = getTopNode(uiWidget);
    Object data = node.getUserData();
    StackPane pane;
    if (data == null) {
      if (remove) {
        return null;
      }
      pane = new StackPane(node);
      node.setUserData(pane);
    } else {
      pane = (StackPane) data;
      if (remove) {
        node.setUserData(null);
      }
    }
    return pane;
  }

  /**
   * @param child the child widget to remove.
   * @param index the index of the child.
   */
  public void removeChildWidget(UiRegularWidget child, int index) {

    Node node = getCellNode(child, true);
    if (node != null) {
      this.widget.getChildren().remove(node);
    }
  }

}
