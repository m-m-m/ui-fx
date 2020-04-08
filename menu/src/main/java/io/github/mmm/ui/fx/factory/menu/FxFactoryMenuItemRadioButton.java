/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.menu;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.menu.UiMenuItemRadioButton;
import io.github.mmm.ui.fx.widget.menu.FxMenuItemRadioButton;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMenuItemRadioButton}.
 *
 * @since 1.0.0
 */
public class FxFactoryMenuItemRadioButton implements UiSingleWidgetFactoryNative<UiMenuItemRadioButton> {

  @Override
  public Class<UiMenuItemRadioButton> getType() {

    return UiMenuItemRadioButton.class;
  }

  @Override
  public UiMenuItemRadioButton create(UiContext context) {

    return new FxMenuItemRadioButton(context);
  }

}
