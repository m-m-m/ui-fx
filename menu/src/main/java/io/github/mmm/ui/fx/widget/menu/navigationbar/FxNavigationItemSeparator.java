/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import io.github.mmm.ui.api.widget.menu.UiMenuItemSeparator;
import io.github.mmm.ui.fx.widget.FxWidgetNode;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.control.Separator;

/**
 * Implementation of {@link UiMenuItemSeparator} for JavaFx and {@link FxNavigationBar}.
 *
 * @since 1.0.0
 */
public class FxNavigationItemSeparator extends FxWidgetNode<Separator> implements UiMenuItemSeparator {

  /**
   * The constructor.
   */
  public FxNavigationItemSeparator() {

    super(new Separator());
    this.widget.setOrientation(Orientation.HORIZONTAL);
    this.widget.setValignment(VPos.CENTER);
  }

}
