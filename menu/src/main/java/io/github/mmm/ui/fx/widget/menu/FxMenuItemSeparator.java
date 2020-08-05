/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu;

import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import io.github.mmm.ui.api.widget.menu.UiMenuItemSeparator;
import javafx.scene.control.SeparatorMenuItem;

/**
 * Implementation of {@link UiMenuItem} for JavaFx and {@link FxMenuBar}.
 *
 * @since 1.0.0
 */
public class FxMenuItemSeparator extends FxAbstractMenuItem<SeparatorMenuItem> implements UiMenuItemSeparator {

  /**
   * The constructor.
   */
  public FxMenuItemSeparator() {

    super(new SeparatorMenuItem());
  }

}
