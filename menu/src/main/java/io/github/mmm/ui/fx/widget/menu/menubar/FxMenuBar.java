/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.menubar;

import io.github.mmm.ui.api.widget.menu.UiAdvancedMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuBar;
import io.github.mmm.ui.api.widget.window.UiMainWindow;
import io.github.mmm.ui.fx.widget.composite.FxRemovableComposite;
import io.github.mmm.ui.fx.widget.window.FxMainWindow;
import javafx.scene.control.MenuBar;

/**
 * Implementation of {@link UiMenuBar} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxMenuBar extends FxRemovableComposite<MenuBar, UiAdvancedMenu> implements UiMenuBar {

  /**
   * The constructor.
   */
  public FxMenuBar() {

    super(((FxMainWindow) UiMainWindow.get()).getMenuBar());
  }

  @Override
  public UiAdvancedMenu addMenu(String text, int index) {

    FxMenu menu = new FxMenu();
    setParent(menu, this);
    menu.setText(text);
    if (index == -1) {
      this.widget.getMenus().add(menu.getWidget());
      this.children.add(menu);
    } else {
      this.widget.getMenus().add(index, menu.getWidget());
      this.children.add(index, menu);
    }
    return menu;
  }

  @Override
  protected void removeChildWidget(UiAdvancedMenu child, int index) {

    this.widget.getMenus().remove(index);
  }

}
