/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import io.github.mmm.ui.api.widget.menu.UiMenuBar;
import io.github.mmm.ui.api.widget.menu.UiNavigationBar;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link UiMenuBar} for JavaFx.
 *
 * @since 1.0.0
 */
public class FxNavigationBar extends FxAbstractMenuWithItems<VBox> implements UiNavigationBar {

  /**
   * The constructor.
   */
  public FxNavigationBar() {

    super(new VBox());
    getStyles().add(STYLE);
  }

  @Override
  protected VBox getVBox() {

    return this.widget;
  }

}
