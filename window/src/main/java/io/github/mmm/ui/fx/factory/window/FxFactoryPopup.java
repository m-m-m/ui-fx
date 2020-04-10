/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.window;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.window.UiPopup;
import io.github.mmm.ui.fx.widget.window.FxPopup;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiPopup}.
 *
 * @since 1.0.0
 */
public class FxFactoryPopup implements UiSingleWidgetFactoryNative<UiPopup> {

  @Override
  public Class<UiPopup> getType() {

    return UiPopup.class;
  }

  @Override
  public UiPopup create() {

    return new FxPopup();
  }

}
