/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import javafx.scene.Node;
import javafx.scene.control.TreeItem;

/**
 * {@link io.github.mmm.ui.api.widget.menu.UiAbstractMenuEntry} for JavaFx.
 *
 * @since 1.0.0
 */
public interface FxNavigationEntry {

  /**
   * @return the {@link TreeItem}.
   */
  TreeItem<Node> getTreeItem();

}
