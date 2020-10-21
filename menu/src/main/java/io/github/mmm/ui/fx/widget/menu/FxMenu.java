/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import java.util.ArrayList;
import java.util.List;

import io.github.mmm.ui.api.event.UiClickEventListener;
import io.github.mmm.ui.api.widget.UiWidget;
import io.github.mmm.ui.api.widget.menu.UiAbstractMenuEntry;
import io.github.mmm.ui.api.widget.menu.UiAdvancedMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import io.github.mmm.ui.api.widget.menu.UiMenuItemCheckbox;
import io.github.mmm.ui.api.widget.menu.UiMenuItemRadioButton;
import io.github.mmm.ui.api.widget.menu.UiMenuItemSeparator;
import io.github.mmm.ui.fx.FxToggleGroup;
import javafx.scene.control.Menu;

/**
 * Implementation of {@link UiAdvancedMenu} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxMenu extends FxAbstractMenuEntry<Menu> implements UiAdvancedMenu {

  private final List<FxAbstractMenuEntry<?>> children;

  private FxToggleGroup toggleGroup;

  /**
   * The constructor.
   */
  public FxMenu() {

    super(new Menu());
    this.children = new ArrayList<>();
  }

  @Override
  public UiAdvancedMenu addMenu(String text, int index) {

    FxMenu menu = new FxMenu();
    UiWidget.initText(menu, text);
    addChild(menu, index);
    return menu;
  }

  @Override
  public UiMenuItem addItem(String text, UiClickEventListener listener, int index) {

    FxMenuItem item = new FxMenuItem();
    UiWidget.initText(item, text);
    if (listener != null) {
      item.addListener(listener);
    }
    addChild(item, index);
    return item;
  }

  @Override
  public UiMenuItemCheckbox addCheckbox(String text, UiClickEventListener listener, int index) {

    FxMenuItemCheckbox item = new FxMenuItemCheckbox();
    UiWidget.initText(item, text);
    item.addListener(listener);
    addChild(item, index);
    return item;
  }

  @Override
  public UiMenuItemRadioButton addRadioButton(String text, UiClickEventListener listener, int index) {

    FxMenuItemRadioButton item = new FxMenuItemRadioButton();
    UiWidget.initText(item, text);
    item.addListener(listener);
    addChild(item, index);
    return item;
  }

  @Override
  public UiMenuItemSeparator addSeparator(int index) {

    FxMenuItemSeparator item = new FxMenuItemSeparator();
    addChild(item, index);
    return item;
  }

  private void addChild(FxAbstractMenuEntry<?> child, int index) {

    setParent(child, this);
    if (index == -1) {
      this.widget.getItems().add(child.getWidget());
      this.children.add(child);
    } else {
      this.widget.getItems().add(index, child.getWidget());
      this.children.add(index, child);
    }
  }

  @Override
  public UiAbstractMenuEntry removeChild(int index) {

    FxAbstractMenuEntry<?> childItem = this.children.remove(index);
    this.widget.getItems().remove(childItem.getWidget());
    return childItem;
  }

  @Override
  public int getChildCount() {

    return this.children.size();
  }

  @Override
  public int getChildIndex(UiAbstractMenuEntry child) {

    return this.children.indexOf(child);
  }

  @Override
  public UiAbstractMenuEntry getChild(int index) {

    if ((index < 0) || (index >= this.children.size())) {
      return null;
    }
    return this.children.get(index);
  }

  /**
   * @return the {@link FxToggleGroup}.
   */
  public FxToggleGroup getToggleGroup() {

    if (this.toggleGroup == null) {
      this.toggleGroup = new FxToggleGroup();
    }
    return this.toggleGroup;
  }

}
