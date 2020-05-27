/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.panel;

import java.util.Iterator;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * Extends {@link GridPane} to fill gaps of JavaFx.
 */
public class AdvancedGridPane extends GridPane {

  /**
   * The constructor.
   */
  public AdvancedGridPane() {

    super();
    ColumnConstraints column1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
    ColumnConstraints column2 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
    column2.setHgrow(Priority.ALWAYS);
    getColumnConstraints().addAll(column1, column2);
  }

  /**
   * @param index the index of the row to delete. All children in this row will be removed, all children in rows after
   *        the removed row will be shifted up.
   */
  public void removeRow(int index) {

    Iterator<Node> iterator = getChildren().iterator();
    while (iterator.hasNext()) {
      Node node = iterator.next();
      Integer nodeRow = getRowIndex(node);
      int row = (nodeRow == null) ? 0 : nodeRow.intValue();
      if (row == index) {
        iterator.remove();
      } else if (row > index) {
        setRowIndex(node, Integer.valueOf(row - 1));
      }
    }
  }

  /**
   * @param rowIndex the {@link #getRowIndex(Node) index} of the row to insert.
   * @param children the children to insert into the new row.
   */
  public void insertRow(int rowIndex, Node... children) {

    for (Node node : getChildren()) {
      Integer nodeRow = getRowIndex(node);
      int row = (nodeRow == null) ? 0 : nodeRow.intValue();
      if (row >= rowIndex) {
        setRowIndex(node, Integer.valueOf(row + 1));
      }
    }
    if (children.length == 1) {
      add(children[0], 0, rowIndex, 2, 1);
    } else {
      int columnIndex = 0;
      for (Node child : children) {
        add(child, columnIndex++, rowIndex);
      }
    }
  }

}
