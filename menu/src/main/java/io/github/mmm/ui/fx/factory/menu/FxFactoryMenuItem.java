/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.menu;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.menu.UiMenuItem;
import io.github.mmm.ui.fx.widget.menu.FxMenuItem;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenuItem}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenuItem implements UiSingleWidgetFactoryNative<UiMenuItem> {

  @Override
  public Class<UiMenuItem> getType() {

    return UiMenuItem.class;
  }

  @Override
  public UiMenuItem create() {

    return new FxMenuItem();
  }

}
