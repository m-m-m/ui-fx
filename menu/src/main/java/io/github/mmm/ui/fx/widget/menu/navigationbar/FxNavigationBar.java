/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import io.github.mmm.ui.api.widget.menu.UiMenuBar;
import io.github.mmm.ui.api.widget.menu.UiNavigationBar;
import javafx.scene.Node;
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
  }

}
