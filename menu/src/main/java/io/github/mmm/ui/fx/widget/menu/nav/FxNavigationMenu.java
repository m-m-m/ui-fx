/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.nav;

import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

/**
 * Implementation of {@link UiMenu} for JavaFx and {@link FxNavigationBar}.
 *
 * @since 1.0.0
 */
public class FxNavigationMenu extends FxAbstractMenuWithItems<Hyperlink> implements UiMenu {

  /**
   * The constructor.
   */
  public FxNavigationMenu() {

    super(new Hyperlink());
    getStyles().add(UiMenuItem.STYLE_NAV);
    ensureHandlers();
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnAction(this::onAction);
  }

  @Override
  public String getText() {

    return this.widget.getText();
  }

  @Override
  public void setText(String text) {

    this.widget.setText(text);
  }

  @Override
  protected void onAction(ActionEvent event) {

    getTreeItem().setExpanded(!getTreeItem().isExpanded());
    super.onAction(event);
  }

}
