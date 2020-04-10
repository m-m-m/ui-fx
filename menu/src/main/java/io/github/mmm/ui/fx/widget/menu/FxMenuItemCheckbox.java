/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import io.github.mmm.ui.api.widget.menu.UiMenuItemCheckbox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;

/**
 * Implementation of {@link UiMenuItem} using JavaFx {@link MenuItem}.
 *
 * @since 1.0.0
 */
public class FxMenuItemCheckbox extends FxAbstractMenuItem<CheckMenuItem> implements UiMenuItemCheckbox {

  /**
   * The constructor.
   */
  public FxMenuItemCheckbox() {

    super(new CheckMenuItem());
  }

  @Override
  public Boolean getValue() {

    return Boolean.valueOf(this.widget.isSelected());
  }

  @Override
  public void setValue(Boolean checked) {

    this.widget.setSelected(Boolean.TRUE.equals(checked));
  }

}
