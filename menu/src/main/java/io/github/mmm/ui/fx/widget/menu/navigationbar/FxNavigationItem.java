/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import io.github.mmm.ui.fx.widget.link.FxAbstractLink;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;

/**
 * Implementation of {@link UiMenuItem} for JavaFx and {@link FxNavigationBar}.
 *
 * @since 1.0.0
 */
public class FxNavigationItem extends FxAbstractLink implements UiMenuItem, FxNavigationEntry {

  private final TreeItem<Node> treeItem;

  /**
   * The constructor.
   */
  public FxNavigationItem() {

    super();
    getStyles().add(STYLE_NAV);
    this.treeItem = new TreeItem<>(this.widget);
  }

  @Override
  public TreeItem<Node> getTreeItem() {

    return this.treeItem;
  }

}
