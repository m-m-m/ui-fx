/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.window;

import io.github.mmm.ui.api.UiContext;
import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.window.UiMainWindow;
import io.github.mmm.ui.fx.widget.window.FxMainWindow;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiMainWindow}.
 *
 * @since 1.0.0
 */
public class FxFactoryMainWindow implements UiSingleWidgetFactoryNative<UiMainWindow> {

  @Override
  public Class<UiMainWindow> getType() {

    return UiMainWindow.class;
  }

  @Override
  public UiMainWindow create(UiContext context) {

    return new FxMainWindow(context);
  }

}
