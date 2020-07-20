/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.navigation;

import io.github.mmm.ui.api.widget.navigation.UiMenuBar;
import io.github.mmm.ui.api.widget.navigation.UiNavigationBar;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiMenuBar} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxNavigationBar extends FxAbstractMenuWithItems<TreeView<Node>> implements UiNavigationBar {

  /**
   * The constructor.
   */
  public FxNavigationBar() {

    super(new TreeView<>());
    getStyles().add(STYLE);
    VBox.setVgrow(this.widget, Priority.ALWAYS);
    this.widget.setRoot(getTreeItem());
    this.widget.setShowRoot(false);
    this.widget.getSelectionModel().selectedItemProperty().addListener(this::onSelection);
  }

  private void onSelection(ObservableValue<? extends TreeItem<Node>> observable, TreeItem<Node> oldValue,
      TreeItem<Node> newValue) {

    if (newValue != null) {
      Node node = newValue.getValue();
      if (node instanceof Hyperlink) {
        ((Hyperlink) node).fire();
      }
    }
  }

}
