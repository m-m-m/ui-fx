/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuBar;
import io.github.mmm.ui.api.widget.window.UiMainWindow;
import io.github.mmm.ui.fx.widget.composite.FxDynamicComposite;
import io.github.mmm.ui.fx.widget.window.FxMainWindow;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

/**
 * Implementation of {@link UiMenuBar} using JavaFx {@link MenuBar}.
 *
 * @since 1.0.0
 */
public class FxMenuBar extends FxDynamicComposite<MenuBar, UiMenu> implements UiMenuBar {

  /**
   * The constructor.
   */
  public FxMenuBar() {

    super(((FxMainWindow) UiMainWindow.get()).getMenuBar());
  }

  private Menu getMenu(UiMenu menu) {

    return ((FxMenu) menu).getWidget();
  }

  @Override
  protected void addChildWidget(UiMenu child, int index) {

    if (index == -1) {
      this.widget.getMenus().add(getMenu(child));
    } else {
      this.widget.getMenus().add(index, getMenu(child));
    }
  }

  @Override
  protected void removeChildWidget(UiMenu child, int index) {

    this.widget.getMenus().remove(index);
  }

}