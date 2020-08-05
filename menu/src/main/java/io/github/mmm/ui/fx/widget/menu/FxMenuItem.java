/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.api.widget.img.UiAbstractImage;
import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import javafx.scene.control.MenuItem;

/**
 * Implementation of {@link UiMenuItem} for JavaFx and {@link FxMenuBar}.
 *
 * @since 1.0.0
 */
public class FxMenuItem extends FxAbstractMenuItem<MenuItem> implements UiMenuItem {

  private UiAbstractImage icon;

  /**
   * The constructor.
   */
  public FxMenuItem() {

    super(new MenuItem());
  }

  @Override
  public UiAbstractImage getImage() {

    return this.icon;
  }

  @Override
  public void setImage(UiAbstractImage icon) {

    this.icon = icon;
    this.widget.setGraphic(getTopNode(icon));
  }

}
