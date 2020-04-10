/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.fx.factory.core;

import io.github.mmm.ui.api.factory.UiSingleWidgetFactoryNative;
import io.github.mmm.ui.api.widget.composite.UiTab;
import io.github.mmm.ui.fx.widget.composite.FxTab;

/**
 * {@link UiSingleWidgetFactoryNative} for {@link UiTab}.
 *
 * @since 1.0.0
 */
public class FxFactoryTab implements UiSingleWidgetFactoryNative<UiTab> {

  @Override
  public Class<UiTab> getType() {

    return UiTab.class;
  }

  @Override
  public UiTab create() {

    return new FxTab();
  }

}
