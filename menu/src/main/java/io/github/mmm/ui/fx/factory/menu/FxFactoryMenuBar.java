/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.menu;

import io.github.mmm.ui.UiContext;
import io.github.mmm.ui.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.fx.widget.menu.FxMenuBar;
import io.github.mmm.ui.widget.menu.UiMenuBar;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenuBar}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenuBar implements UiSingleWidgetFactoryNative<UiMenuBar> {

  @Override
  public Class<UiMenuBar> getType() {

    return UiMenuBar.class;
  }

  @Override
  public UiMenuBar create(UiContext context) {

    return new FxMenuBar(context);
  }

}
