/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.navigation;

import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.widget.navigation.UiAbstractMenuEntry;
import io.github.mmm.ui.api.widget.navigation.UiAbstractMenuWithItems;
import io.github.mmm.ui.api.widget.navigation.UiMenu;
import io.github.mmm.ui.api.widget.navigation.UiMenuItem;
import io.github.mmm.ui.api.widget.navigation.UiMenuItemSeparator;
import io.github.mmm.ui.api.widget.navigation.UiNavigationBar;
import io.github.mmm.ui.fx.widget.composite.FxRemovableComposite;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;

/**
 * Implementation of {@link UiAbstractMenuWithItems} for JavaFx and {@link FxNavigationBar}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractMenuWithItems<W extends Node> extends FxRemovableComposite<W, UiAbstractMenuEntry>
    implements UiAbstractMenuWithItems, FxNavigationEntry {

  private final TreeItem<Node> treeItem;

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractMenuWithItems(W widget) {

    super(widget);
    if (this instanceof UiNavigationBar) {
      this.treeItem = new TreeItem<>();
    } else {
      this.treeItem = new TreeItem<>(widget);
    }
    this.treeItem.setExpanded(true);
  }

  @Override
  public TreeItem<Node> getTreeItem() {

    return this.treeItem;
  }

  @Override
  public UiMenu addMenu(String text, int index) {

    FxNavigationMenu menu = new FxNavigationMenu();
    menu.setText(text);
    addChild(menu, index);
    return menu;
  }

  @Override
  public UiMenuItem addItem(String text, UiClickEventListener listener, int index) {

    FxNavigationItem item = new FxNavigationItem();
    if (text != null) {
      item.setText(text);
    }
    if (listener != null) {
      item.addListener(listener);
    }
    addChild(item, index);
    return item;
  }

  @Override
  public UiMenuItemSeparator addSeparator(int index) {

    FxNavigationItemSeparator separator = new FxNavigationItemSeparator();
    addChild(separator, index);
    return separator;
  }

  private void addChild(UiAbstractMenuEntry child, int index) {

    setParent(child, this);
    TreeItem<Node> childItem = ((FxNavigationEntry) child).getTreeItem();
    if (index == -1) {
      this.treeItem.getChildren().add(childItem);
      this.children.add(child);
    } else {
      this.treeItem.getChildren().add(index, childItem);
      this.children.add(index, child);
    }
  }

  @Override
  protected void removeChildWidget(UiAbstractMenuEntry child, int index) {

    this.treeItem.getChildren().remove(index);
  }

}
