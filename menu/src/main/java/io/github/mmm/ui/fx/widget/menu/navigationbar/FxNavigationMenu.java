/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import io.github.mmm.ui.api.widget.img.UiIcon;
import io.github.mmm.ui.api.widget.menu.UiMenu;
import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiMenu} for JavaFx and {@link FxNavigationBar}.
 *
 * @since 1.0.0
 */
public class FxNavigationMenu extends FxAbstractMenuWithItems<Hyperlink> implements UiMenu {

  private final VBox topWidget;

  private final UiIcon icon;

  private boolean collapsed;

  /**
   * The constructor.
   */
  public FxNavigationMenu() {

    super(new Hyperlink());
    this.topWidget = new VBox();
    this.topWidget.getStyleClass().add(STYLE_NAV);
    getStyles().add(UiMenuItem.STYLE_NAV);
    this.icon = UiIcon.of(UiIcon.ID_COLLAPSE);
    this.widget.setGraphic(getTopNode(this.icon));
  }

  @Override
  protected void registerHandlers() {

    super.registerHandlers();
    this.widget.setOnAction(this::onAction);
  }

  @Override
  public VBox getTopWidget() {

    return this.topWidget;
  }

  @Override
  protected VBox getVBox() {

    return this.topWidget;
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

    this.topWidget.setVisible(this.collapsed);
    this.topWidget.setManaged(this.collapsed);
    if (this.collapsed) {
      this.icon.setIconId(UiIcon.ID_COLLAPSE);
    } else {
      this.icon.setIconId(UiIcon.ID_EXPAND);
    }
    this.collapsed = !this.collapsed;
    super.onAction(event);
  }

}
