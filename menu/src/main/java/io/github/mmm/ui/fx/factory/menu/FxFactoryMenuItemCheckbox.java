/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.menu;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.menu.UiMenuItemCheckbox;
import io.github.mmm.ui.fx.widget.menu.FxMenuItemCheckbox;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenuItemCheckbox}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenuItemCheckbox implements UiSingleWidgetFactoryNative<UiMenuItemCheckbox> {

  @Override
  public Class<UiMenuItemCheckbox> getType() {

    return UiMenuItemCheckbox.class;
  }

  @Override
  public UiMenuItemCheckbox create() {

    return new FxMenuItemCheckbox();
  }

}
