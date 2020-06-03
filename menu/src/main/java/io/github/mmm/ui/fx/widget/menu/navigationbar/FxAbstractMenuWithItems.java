/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import io.github.mmm.ui.api.event.UiEventListener;
import io.github.mmm.ui.api.widget.menu.UiAbstractMenuEntry;
import io.github.mmm.ui.api.widget.menu.UiAbstractMenuWithItems;
import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import io.github.mmm.ui.api.widget.menu.UiMenuItemSeparator;
import io.github.mmm.ui.fx.widget.composite.FxRemovableComposite;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiAbstractMenuWithItems} for JavaFx and {@link FxNavigationBar}.
 *
 * @param <W> type of {@link #getWidget() JavaFx widget}.
 * @since 1.0.0
 */
public abstract class FxAbstractMenuWithItems<W extends Node> extends FxRemovableComposite<W, UiAbstractMenuEntry>
    implements UiAbstractMenuWithItems {

  /**
   * The constructor.
   *
   * @param widget the {@link #getWidget() JavaFx widget}.
   */
  public FxAbstractMenuWithItems(W widget) {

    super(widget);
  }

  /**
   * @return the {@link VBox} as container for the children.
   */
  protected abstract VBox getVBox();

  @Override
  public UiMenu addMenu(String text, int index) {

    FxNavigationMenu menu = new FxNavigationMenu();
    menu.setText(text);
    addChild(menu, index);
    return menu;
  }

  @Override
  public UiMenuItem addItem(String text, UiEventListener listener, int index) {

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

    Node node = getTopNode(child);
    setParent(child, this);
    if (index == -1) {
      getVBox().getChildren().add(node);
      this.children.add(child);
    } else {
      getVBox().getChildren().add(index, node);
      this.children.add(index, child);
    }
  }

  @Override
  protected void removeChildWidget(UiAbstractMenuEntry child, int index) {

    getVBox().getChildren().remove(index);
  }

}
