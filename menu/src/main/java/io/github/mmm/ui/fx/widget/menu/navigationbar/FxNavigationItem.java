/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.widget.menu.navigationbar;

import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import io.github.mmm.ui.fx.widget.link.FxAbstractLink;

/**
 * Implementation of {@link UiMenuItem} for JavaFx and {@link FxNavigationBar}.
 *
 * @since 1.0.0
 */
public class FxNavigationItem extends FxAbstractLink implements UiMenuItem {

  /**
   * The constructor.
   */
  public FxNavigationItem() {

    super();
    getStyles().add(STYLE_NAV);
  }

}
